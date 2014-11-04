package com.sns.wechat.mp.response;
import com.sns.wechat.mp.ResponseBase;

/**
 * 群发返回结果
 * @author Tian Zhiyuan
 * @date 2014年10月11日
 * @version 0.1
 */
public class SendMassMessageResponse extends ResponseBase {
	/**
	 * 消息id
	 */
	private long msg_id;
	/**
	 * 消息类型 
	 * @see WeChatMessageTypes
	 */
	private String type;
	public long getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(long msg_id) {
		this.msg_id = msg_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
