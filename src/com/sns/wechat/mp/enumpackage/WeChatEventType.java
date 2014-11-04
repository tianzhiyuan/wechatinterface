package com.sns.wechat.mp.enumpackage;

/**
 * 微信事件类型
 * @author Tian Zhiyuan
 *
 */
public enum WeChatEventType {
	/**
	 * 关注事件
	 */
	EVENT_SUBSCRIBE("subscribe"),
	/**
	 * 取消关注事件
	 */
	EVENT_UNSUBSCRIBE("unsubscribe"),
	/**
	 * 扫描二维码事件
	 */
	EVENT_SCAN("SCAN"),
	/**
	 * 位置信息事件
	 */
	EVENT_LOCATION("LOCATION"),
	/**
	 * 自定义菜单点击事件
	 */
	EVENT_CLICK("CLICK"),
	/**
	 * 自定义菜单浏览事件
	 */
	EVENT_VIEW("VIEW"),
	/**
	 * 群发消息完成事件
	 */
	EVENT_MASSSENDJOBFINISH("MASSSENDJOBFINISH"),
	
	/**
	 * 模版消息发送任务完成
	 */
	EVENT_TEMPLATESENDJOBFINISH("TEMPLATESENDJOBFINISH");
	private String oType;
	private WeChatEventType(String oType){
		this.oType = oType;
	}
	@Override
	public String toString(){
		return this.oType;
	}
	public static WeChatEventType fromString(String text){
		if(text != null){
			for (WeChatEventType b : WeChatEventType.values()) {
		        if (text.equals(b.oType)) {
		          return b;
		        }
		      }
		}
		throw new IllegalArgumentException("No constant with text " + text + " found");
	}
}
