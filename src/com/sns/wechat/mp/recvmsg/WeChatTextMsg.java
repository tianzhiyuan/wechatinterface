package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 微信文本消息
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatTextMsg extends WeChatNormalMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.dbcsoft.shopping.service.local.wechat.WeChatBaseMsg#getMsgType()
	 */
	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return WeChatMessageType.TEXT.toString();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 文本内容
	 */
	private String content;
	
}
