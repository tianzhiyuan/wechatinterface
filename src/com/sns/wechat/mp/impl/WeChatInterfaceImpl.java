package com.sns.wechat.mp.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Formatter;

import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import com.sns.wechat.mp.JsonSerializer;
import com.sns.wechat.mp.RequestBase;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.ResponseBase;
import com.sns.wechat.mp.WeChatInterface;
import com.sns.wechat.mp.request.UploadMedia;
import com.sns.wechat.mp.response.UploadResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

/**
 * 微信公众号接口实现
 * 
 * TODO 未实现的接口：
 * 			1. 删除群发消息接口
 * 			2. 获取客服聊天记录接口
 * 			3. 获取自定义菜单接口
 * 			4. 发送模版消息接口
 * 		待优化：
 * 			1. 某些接口序列化为json时使用字符串拼接的方式，因此不支持特殊字符，比如引号。具体可以查看getData()实现
 * @author Tian Zhiyuan
 * @date 2014年10月15日
 * @version 0.1
 */

public class WeChatInterfaceImpl implements WeChatInterface {

	private static Client client;

	/**
	 * jersey client 创建是非常消耗资源的过程， 这里使用单例优化性能
	 * 注意：
	 * 		client本身一些方法是不可重入的，必须在创建时调用。
	 */
	private synchronized static Client getClient(int timeout) {
		if (client == null) {
			client = Client.create();
			client.addFilter(new LoggingFilter(System.out));
			client.setConnectTimeout(timeout * 1000);
		}
		return client;
	}

	@Resource
	private JsonSerializer jsonSerializer;

	public JsonSerializer getJsonSerializer() {
		return jsonSerializer;
	}

	public void setJsonSerializer(JsonSerializer jsonSerializer) {
		this.jsonSerializer = jsonSerializer;
	}

	/**
	 * 微信公众平台api基地址
	 */
	private String apiUrlBase = "https://api.weixin.qq.com";

	public String getApiUrlBase() {
		return apiUrlBase;
	}

	/**
	 * 请求超时时间
	 */
	private int timeOutSeconds = 10;

	public WeChatInterfaceImpl() {

	}

	public WeChatInterfaceImpl(int timeOut) {
		this.timeOutSeconds = timeOut;
	}

	public int getTimeOutSeconds() {
		return timeOutSeconds;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <TResponse extends ResponseBase> TResponse execute(
			RequestBase<TResponse> request) {
		if (request instanceof UploadMedia) {
			return (TResponse) execute((UploadMedia) request);
		}
		Class<?> requestClass = request.getClass();
		RequestMethod.Method method = ((RequestMethod) requestClass
				.getAnnotation(RequestMethod.class)).value();
		RequestPath requestPath = ((RequestPath) requestClass
				.getAnnotation(RequestPath.class));
		String path = requestPath.value();
		String param = request.getParam();
		String url = this.apiUrlBase + path;
		if (requestPath.isFullPath()) {
			url = path;
		}
		try {
			Client client = getClient(this.timeOutSeconds);
			if (param != null && param != "") {
				url += "?" + param;
			}
			WebResource webResource = client.resource(url);
			webResource.type(MediaType.APPLICATION_JSON).accept(
					MediaType.APPLICATION_JSON);
			ClientResponse clientResponse;
			if (method == RequestMethod.Method.GET) {
				clientResponse = webResource.get(ClientResponse.class);
			} else {
				clientResponse = webResource.post(ClientResponse.class,
						request.getData());
			}

			// TResponse response =
			// (TResponse)clientResponse.getEntity(GenericsUtils.getSuperClassGenricType(requestClass));
			// return response;
			String result = clientResponse.getEntity(String.class);
			TResponse response = (TResponse) jsonSerializer
					.deserialize(
							getSuperClassGenricType(requestClass, 0),
							result);
			return response;
		} catch (Exception error) {
			error.printStackTrace();
		}
		return null;
	}

	/**
	 * 上传多媒体接口实现
	 * 该接口需要上传文件，需要特殊处理，并且jersey client不能很好的适应此功能。
	 * @param request
	 * @return
	 */
	public UploadResponse execute(UploadMedia request) {
		Class<?> requestClass = request.getClass();

		RequestPath requestPath = ((RequestPath) requestClass
				.getAnnotation(RequestPath.class));
		String path = requestPath.value();
		String param = request.getParam();
		String url = this.apiUrlBase + path;
		if (requestPath.isFullPath()) {
			url = path;
		}
		if (param != null && param != "") {
			url += "?" + param;
		}

		try {
			URL uri = new URL(url);
			HttpURLConnection con = (HttpURLConnection) uri.openConnection();

			con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false); // post方式不能使用缓存

			// 设置请求头信息
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			// 设置边界
			String BOUNDARY = "----------" + System.currentTimeMillis();
			con.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + BOUNDARY);
			StringBuilder sb = new StringBuilder();
			sb.append("--"); // 必须多两道线
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
					+ "a.jpg" + "\"\r\n");
			sb.append("Content-Type:application/octet-stream\r\n\r\n");

			byte[] head = sb.toString().getBytes("utf-8");
			OutputStream out = new DataOutputStream(con.getOutputStream());
			out.write(head);

			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = request.getInputStream().read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			request.getInputStream().close();

			byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
			out.write(foot);

			out.flush();
			out.close();

			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
				String result = buffer.toString();
				UploadResponse response = (UploadResponse) jsonSerializer
						.deserialize(
								UploadResponse.class,
								result);
				return response;

			} catch (IOException e) {
				System.out.println("发送POST请求出现异常！" + e);
				e.printStackTrace();
				throw new IOException("数据读取异常");
			} finally {
				if (reader != null) {
					reader.close();
				}

			}
		} catch (Exception error) {

		}
		return null;
	}

	@Override
	public boolean VerifySignature(String nonce, String timestamp,
			String token, String signature) {
		String[] paramList = new String[] { nonce, timestamp, token };
		Arrays.sort(paramList);
		String paramString = "";
		for (String param : paramList) {
			paramString += param;
		}
		String sha1 = encryptSha1(paramString);
		return signature.equals(sha1);
	}

	private static String encryptSha1(String source) {
		String sha1 = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(source.getBytes("UTF-8"));
			sha1 = byteToHex(crypt.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sha1;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
	
	/**  
     * 通过反射,获得指定类的父类的泛型参数的实际类型. 如BuyerServiceBean extends DaoSupport<Buyer>  
     *  
     * @param clazz clazz 需要反射的类,该类必须继承范型父类
     * @param index 泛型参数所在索引,从0开始.  
     * @return 范型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */  
    @SuppressWarnings({ "rawtypes" })
	private static Class getSuperClassGenricType(Class clazz, int index) {    
        Type genType = clazz.getGenericSuperclass();//得到泛型父类  
        //如果没有实现ParameterizedType接口，即不支持泛型，直接返回Object.class   
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;   
        }  
        //返回表示此类型实际类型参数的Type对象的数组,数组里放的都是对应类型的Class, 如BuyerServiceBean extends DaoSupport<Buyer,Contact>就返回Buyer和Contact类型   
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();                   
        if (index >= params.length || index < 0) { 
        	 throw new RuntimeException("你输入的索引"+ (index<0 ? "不能小于0" : "超出了参数的总数"));
        }      
        if (!(params[index] instanceof Class)) {
            return Object.class;   
        }   
        return (Class) params[index];
    }
}
