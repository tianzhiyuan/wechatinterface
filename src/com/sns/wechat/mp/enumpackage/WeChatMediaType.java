package com.sns.wechat.mp.enumpackage;

/**
 * 微信媒体类型
 * @author Tian Zhiyuan
 * @date 2014年10月14日
 * @version 0.1
 */
public enum WeChatMediaType {
	/**
	 * 图片 
	 */
	IMAGE("image"),
	/**
	 * 语音
	 */
	VOICE("voice"),
	/**
	 * 视频
	 */
	VIDEO("video"),
	/**
	 * 缩略图
	 */
	THUMB("thumb");
	private String oType;
	private WeChatMediaType(String oType){
		this.oType = oType;
	}
	@Override
	public String toString(){
		return this.oType;
	}
}
