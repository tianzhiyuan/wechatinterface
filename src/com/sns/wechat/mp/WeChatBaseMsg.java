package com.sns.wechat.mp;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sns.wechat.mp.enumpackage.WeChatEventType;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;
import com.sns.wechat.mp.recvmsg.WeChatImageMsg;
import com.sns.wechat.mp.recvmsg.WeChatLinkMsg;
import com.sns.wechat.mp.recvmsg.WeChatLocationEvent;
import com.sns.wechat.mp.recvmsg.WeChatLocationMsg;
import com.sns.wechat.mp.recvmsg.WeChatMassSendJobEvent;
import com.sns.wechat.mp.recvmsg.WeChatMenuClickEvent;
import com.sns.wechat.mp.recvmsg.WeChatMenuViewEvent;
import com.sns.wechat.mp.recvmsg.WeChatScanQrEvent;
import com.sns.wechat.mp.recvmsg.WeChatSubscribeEvent;
import com.sns.wechat.mp.recvmsg.WeChatTemplateSendJobEvent;
import com.sns.wechat.mp.recvmsg.WeChatTextMsg;
import com.sns.wechat.mp.recvmsg.WeChatUnSubscribeEvent;
import com.sns.wechat.mp.recvmsg.WeChatVideoMsg;
import com.sns.wechat.mp.recvmsg.WeChatVoiceMsg;
import com.sun.xml.internal.txw2.annotation.XmlElement;
/**
 * 微信推送消息基类
 * 
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
@XmlRootElement(name = "xml")
public abstract class WeChatBaseMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 接收方帐号（收到的OpenID）
	 */
	@JsonProperty("touser")
	private String toUserName;
	/**
	 * 开发者微信号
	 * 客服消息类型此属性不需要设置，可以为空
	 */
	@JsonIgnore
	private String fromUserName;
	/**
	 * 创建时间，linux时间戳
	 */
	@JsonIgnore
	private long createTime;

	@XmlElement("ToUserName")
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	@XmlElement(value = "FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	@XmlElement("CreateTime")
	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString(){
		Class<?> cls = this.getClass();
		StringBuffer buffer = new StringBuffer();
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
	
	/**
	 * 找到字段对应的get方法
	 * 注意：
	 * 		java中如果字段为bool类型，通常把get方法命名为isXXX
	 * @param cls	class
	 * @param field	字段
	 * @return	对应的get方法
	 */
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
	/**
	 * 消息类型 {@link WeChatMessageType}
	 */
	@XmlElement("MsgType")
	@JsonProperty("msgtype")
	public abstract String getMsgType();

	/**
	 * 将微信post的xml消息反序列化为相应的对象
	 * @param xmlString
	 * @return 反序列化后对象
	 */
	public static WeChatBaseMsg Deserialize(String xmlString) {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new ByteArrayInputStream(xmlString
					.getBytes("UTF-8")));
			Element root = document.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> elementList = root.elements();
			for (Element e : elementList)
				// 遍历xml将数据写入map
				map.put(e.getName(), e.getText());

			String msgType = map.get("MsgType");
			WeChatBaseMsg msg = null;
			switch (WeChatMessageType.fromString(msgType)) {
			case EVENT:
				String evtType = map.get("Event");
				switch (WeChatEventType.fromString(evtType)) {
				case EVENT_CLICK:
					WeChatMenuClickEvent click = new WeChatMenuClickEvent();
					click.setEventKey(map.get("EventKey"));
					msg = click;
					break;
				case EVENT_LOCATION:
					WeChatLocationEvent loca = new WeChatLocationEvent();
					loca.setLatitude(Double.parseDouble(map.get("Latitude")));
					loca.setLongitude(Double.parseDouble(map.get("Longitude")));
					loca.setPrecision(Double.parseDouble(map.get("Precision")));
					msg = loca;
					break;
				case EVENT_MASSSENDJOBFINISH:
					WeChatMassSendJobEvent massSendJobEvent = new WeChatMassSendJobEvent();
					massSendJobEvent.setErrorCount(Integer.parseInt(map
							.get("ErrorCount")));
					massSendJobEvent.setFilterCount(Integer.parseInt(map
							.get("FilterCount")));
					massSendJobEvent.setMsgId(Long.parseLong(map.get("MsgId")));
					massSendJobEvent.setSendCount(Integer.parseInt(map
							.get("SendCount")));
					massSendJobEvent.setStatus(map.get("Status"));
					massSendJobEvent.setTotalCount(Integer.parseInt(map
							.get("TotalCount")));
					msg = massSendJobEvent;
					break;
				case EVENT_SCAN:
					WeChatScanQrEvent scanQrEvent = new WeChatScanQrEvent();
					scanQrEvent.setEventKey(map.get("EventKey"));
					scanQrEvent.setTicket(map.get("Ticket"));
					msg = scanQrEvent;
					break;
				case EVENT_SUBSCRIBE:
					WeChatSubscribeEvent subscribeEvent = new WeChatSubscribeEvent();
					subscribeEvent.setEventKey(map.get("EventKey"));
					msg = subscribeEvent;
					break;
				case EVENT_TEMPLATESENDJOBFINISH:
					WeChatTemplateSendJobEvent templateSendJobEvent = new WeChatTemplateSendJobEvent();
					templateSendJobEvent.setMsgId(Long.parseLong("MsgId"));
					templateSendJobEvent.setStatus("Status");
					msg = templateSendJobEvent;
					break;
				case EVENT_UNSUBSCRIBE:
					WeChatUnSubscribeEvent unSubscribeEvent = new WeChatUnSubscribeEvent();
					msg = unSubscribeEvent;
					break;
				case EVENT_VIEW:
					WeChatMenuViewEvent view = new WeChatMenuViewEvent();
					view.setEventKey(map.get("EventKey"));
					msg = view;
					break;
				default:
					break;

				}

				break;
			case IMAGE:
				WeChatImageMsg imageMsg = new WeChatImageMsg();
				imageMsg.setMsgId(Long.parseLong(map.get("MsgId")));
				imageMsg.setPicUrl(map.get("PicUrl"));
				msg = imageMsg;
				break;
			case LINK:
				WeChatLinkMsg linkMsg = new WeChatLinkMsg();
				linkMsg.setMsgId(Long.parseLong(map.get("MsgId")));
				linkMsg.setDescription(map.get("Description"));
				linkMsg.setTitle(map.get("Title"));
				linkMsg.setUrl(map.get("Url"));
				msg = linkMsg;
				break;
			case LOCATION:
				WeChatLocationMsg locationMsg = new WeChatLocationMsg();
				locationMsg.setMsgId(Long.parseLong(map.get("MsgId")));
				locationMsg.setLabel(map.get("Label"));
				locationMsg.setLocation_X(Double.parseDouble(map
						.get("Location_X")));
				locationMsg.setLocation_Y(Double.parseDouble(map
						.get("Location_Y")));
				locationMsg.setScale(Integer.parseInt(map.get("Scale")));
				msg = locationMsg;
				break;
			case TEXT:
				WeChatTextMsg textMsg = new WeChatTextMsg();
				textMsg.setContent(map.get("Content"));
				textMsg.setMsgId(Long.parseLong(map.get("MsgId")));
				msg = textMsg;
				break;
			case VIDEO:
				WeChatVideoMsg videoMsg = new WeChatVideoMsg();
				videoMsg.setMediaId(map.get("MediaId"));
				videoMsg.setMsgId(Long.parseLong(map.get("MsgId")));
				videoMsg.setThumbMediaId(map.get("ThumbMediaId"));
				msg = videoMsg;
				break;
			case VOICE:
				WeChatVoiceMsg voiceMsg = new WeChatVoiceMsg();
				voiceMsg.setMsgId(Long.parseLong(map.get("MsgId")));
				voiceMsg.setFormat(map.get("Format"));
				voiceMsg.setMediaId(map.get("MediaId"));
				voiceMsg.setRecognition(map.get("Recognition"));
				msg = voiceMsg;
				break;
			default:
				break;

			}
			if (msg != null) {
				msg.setCreateTime(Long.parseLong(map.get("CreateTime")));
				msg.setFromUserName("FromUserName");
				msg.setToUserName("ToUserName");
				return msg;
			}
		} catch (Exception error) {
			error.printStackTrace();
		}
		return null;
	}

//	public String Serialize() {
//		Object object = this;
//		StringWriter writer = new StringWriter();
//		JAXBContext context = getContext(object.getClass());
//		if (context != null) {
//			try {
//				Marshaller m = context.createMarshaller();
//				m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//				m.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
//				/*XMLOutputFactory xof = XMLOutputFactory.newInstance();
//				XMLStreamWriter streamWriter = xof
//						.createXMLStreamWriter(writer);
//				CDataXMLStreamWriter cdataStreamWriter = new CDataXMLStreamWriter(
//						streamWriter);*/
//				
//				m.marshal(object, writer);
//				
//				//cdataStreamWriter.flush();
//				//cdataStreamWriter.close();
//				return writer.toString();
//			} catch (Exception error) {
//				error.printStackTrace();
//			}
//		}
//		return null;
//	}

	private static Dictionary<Class<?>, JAXBContext> contexts;
	static {
		contexts = new Hashtable<Class<?>, JAXBContext>();

	}

	@SuppressWarnings("unused")
	private synchronized static JAXBContext getContext(Class<?> cls) {
		JAXBContext ctx = contexts.get(cls);
		if (ctx == null) {
			try {
				ctx = JAXBContext.newInstance(cls);
				contexts.put(cls, ctx);
			} catch (Exception error) {

			}
		}
		return ctx;
	}
}
