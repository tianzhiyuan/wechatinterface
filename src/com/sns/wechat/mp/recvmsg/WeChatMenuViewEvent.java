package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatEventType;

/**
 * 用户点击自定义菜单后，微信会把点击事件推送给开发者，请注意，点击菜单弹出子菜单，不会产生上报。
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatMenuViewEvent extends WeChatEventMsg implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getEvent() {
		// TODO Auto-generated method stub
		return WeChatEventType.EVENT_VIEW.toString();
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	/**
	 * 设置的跳转URL
	 */
	private String EventKey;
}
