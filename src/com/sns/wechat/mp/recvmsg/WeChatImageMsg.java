package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 微信图片消息
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatImageMsg extends WeChatNormalMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String picUrl;

	
	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	@Override
	public String getMsgType(){
		return WeChatMessageType.IMAGE.toString();
	}
}
