package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatEventType;

/**
 * 模版消息送达推送
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatTemplateSendJobEvent extends WeChatEventMsg implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.dbcsoft.shopping.service.local.wechat.recvmsg.WeChatEventMsg#getEvent()
	 */
	@Override
	public String getEvent() {
		// TODO Auto-generated method stub
		return WeChatEventType.EVENT_TEMPLATESENDJOBFINISH.toString();
	}

	private long msgId;
	/**
	 * 成功时 Status=success
	 * 失败时 Status=failed:userblock 或者 Status=failed:system failed
	 */
	private String status;

	public long getMsgId() {
		return msgId;
	}
	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
