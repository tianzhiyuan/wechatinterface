package com.sns.wechat.mp;
import java.lang.reflect.*;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * 微信回复基类
 * @author Tian Zhiyuan
 * */
public abstract class ResponseBase {
	/**
	 * 错误码
	 * 为0时表示调用正确，其他说明发生错误
	 */
	@JsonProperty("errcode")
	private int errcode;
	/**
	 * 发生错误时的消息
	 */
	@JsonProperty("errmsg")
	private String errmsg;
	
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	@Override
	public String toString(){
		Class<?> cls = this.getClass();
		StringBuffer buffer = new StringBuffer();
		//如果errcode不为0，说明出现了错误，此时微信不会返回其他字段的。
		if(this.getErrcode() != 0){
			return String.format("errcode:%d, errmsg:%s",  this.getErrcode(), this.getErrmsg());
		}
		java.lang.reflect.Field[] fields = cls.getDeclaredFields();
		try{
			for(java.lang.reflect.Field field :fields){
				String fieldName = field.getName();
				Method getMethod = tryFindGetMethodByField(cls, field);
				if(getMethod == null){
					continue;
				}
				Object fieldValue= getMethod.invoke(this);
				if(fieldValue instanceof String){
					buffer.append(fieldName)
					  .append(": \"")
					  .append(fieldValue)
					  .append("\",");
				}
				else{
					buffer.append(fieldName)
					  .append(": ")
					  .append(fieldValue)
					  .append(",");
				}
				
			}
		}catch(Exception error){
			error.printStackTrace();
		}
		
		return buffer.toString();
	}
	
	private static String getMethodName(String fildeName, String prefix) throws Exception{
		  byte[] items = fildeName.getBytes();
		  items[0] = (byte) ((char) items[0] - 'a' + 'A');
		  return prefix+new String(items);
	}
	
	private static Method tryFindGetMethodByField(Class<?> cls, Field field){
		String fieldName = field.getName();
		Method getMethod = null;
		if(field.getClass().equals(boolean.class) || field.getClass().equals(Boolean.class)){
			try{
				getMethod = (Method)cls.getMethod(getMethodName(fieldName, "is"));
			}
			catch(Exception error){
				
			}
		}
		if(getMethod == null){
			try{
				getMethod = (Method)cls.getMethod(getMethodName(fieldName, "get"));
			}
			catch(Exception error){
				error.printStackTrace();
			}
		}
		return getMethod;
	}
}
