package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 微信链接消息
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatLinkMsg extends WeChatNormalMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6109197958649395302L;

	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return WeChatMessageType.LINK.toString();
	}

	private String title;
	private String description;
	private String url;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
