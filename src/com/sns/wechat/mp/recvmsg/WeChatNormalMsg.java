package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.WeChatBaseMsg;

/**
 * 微信普通消息基类
 * 这类消息是用户主动使用微信向公众号发送的。微信服务器会将这类消息以XML数据包的形式POST到开发者填写的URL上。
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public abstract class WeChatNormalMsg extends WeChatBaseMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private long msgId;

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}
	

}
