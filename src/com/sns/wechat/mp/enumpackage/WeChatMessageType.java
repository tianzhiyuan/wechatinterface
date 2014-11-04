package com.sns.wechat.mp.enumpackage;

/**
 * 微信消息类型
 * @author Tian Zhiyuan
 *
 */
public enum WeChatMessageType {
	/**
	 * 文本
	 */
	TEXT("text"),
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
	 * 位置
	 */
	LOCATION("location"),
	/**
	 * 链接
	 */
	LINK("link"),
	/**
	 * 事件
	 */
	EVENT("event"),
	/**
	 * 多图文
	 */
	NEWS("news"),
	/**
	 * 音乐
	 */
	MUSIC("music"),
	/**
	 * 转发客服
	 */
	TRANSFER_CUSTOMER_SERVICE("transfer_customer_service");
	
	private String oType;
	private WeChatMessageType(String oType){
		this.oType = oType;
	}
	@Override
	public String toString(){
		return this.oType;
	}
	
	public static WeChatMessageType fromString(String text){
		if(text != null){
			for (WeChatMessageType b : WeChatMessageType.values()) {
		        if (text.equals(b.oType)) {
		          return b;
		        }
		      }
		}
		throw new IllegalArgumentException("No constant with text " + text + " found");
	}
}
