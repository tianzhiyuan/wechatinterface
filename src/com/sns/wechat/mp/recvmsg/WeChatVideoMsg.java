package com.sns.wechat.mp.recvmsg;

import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 微信视频消息
 * @author Tian Zhiyuan
 * @date 2014年10月11日
 * @version 0.1
 */
public class WeChatVideoMsg extends WeChatMediaMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return WeChatMessageType.VIDEO.toString();
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String thumbMediaId;
	
	
}
