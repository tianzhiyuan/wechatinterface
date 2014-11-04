package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

/**
 * 微信多媒体消息
 * @author Tian Zhiyuan
 * @date 2014年10月11日
 * @version 0.1
 */
public abstract class WeChatMediaMsg extends WeChatNormalMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	

}
