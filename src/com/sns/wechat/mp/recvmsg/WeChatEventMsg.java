package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.WeChatBaseMsg;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 微信事件推送基类
 * 
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public abstract class WeChatEventMsg extends WeChatBaseMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 事件类型
	 */
	public abstract String getEvent();

	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return WeChatMessageType.EVENT.toString();
	}
}
