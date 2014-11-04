package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatEventType;

/**
 * 取消关注事件
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatUnSubscribeEvent extends WeChatEventMsg implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.dbcsoft.shopping.service.local.wechat.recvmsg.WeChatEventMsg#getEvent()
	 */
	@Override
	public String getEvent() {
		// TODO Auto-generated method stub
		return WeChatEventType.EVENT_UNSUBSCRIBE.toString();
	}

}
