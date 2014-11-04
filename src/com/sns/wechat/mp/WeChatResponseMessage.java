/**
 * 
 */
package com.sns.wechat.mp;

/**
 * 被动响应消息和客服消息的基类
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public abstract class WeChatResponseMessage extends WeChatBaseMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 将该消息序列化为xml字符串
	 * 注意：回复给微信的xml不可以包含xml头，root必须为xml，string类型的字段必须序列化为CDATA
	 *    由于java的xml序列化类库太难用，不支持定制和扩展，这里使用字符串拼接的方式获取
	 * @return 序列化后的xml字符串
	 */
	public String Serialize(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<xml>");
		buffer.append(Write("ToUserName", getToUserName()));
		buffer.append(Write("FromUserName", getFromUserName()));
		buffer.append(Write("MsgType", getMsgType()));
		buffer.append(Write("CreateTime", getCreateTime()));
		buffer.append(WriteLocal());
		buffer.append("</xml>");
		return buffer.toString();
	}

	protected abstract String WriteLocal();
	protected String Write(String name, int value){
		return String.format("<%s>%s</%s>", name, "" + value, name);
	}
	protected String Write(String name, String value){
		return String.format("<%s><![CDATA[%s]]></%s>", name, value, name);
	}
	protected String Write(String name, long value){
		return String.format("<%s>%s</%s>", name, "" + value, name);
	}
	protected String WriteObject(String name, String value){
		return String.format("<%s>%s</%s>", name, value, name);
	}
}
