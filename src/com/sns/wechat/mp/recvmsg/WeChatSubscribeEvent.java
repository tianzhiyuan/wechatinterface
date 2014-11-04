package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatEventType;

/**
 * 用户关注事件
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatSubscribeEvent extends WeChatEventMsg implements
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
		return WeChatEventType.EVENT_SUBSCRIBE.toString();
	}
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	/**
	 * 扫描二维码时，如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者
	 * 
	 */
	private String eventKey;
	/**
	 * 获取场景值id
	 * @return sceneid（场景值id）
	 */
	public int GetSceneId(){
		if(this.eventKey == null) return 0;
		if(this.eventKey.split("_").length > 1){
			String scene = this.eventKey.split("_")[1];
			try{
				return Integer.parseInt(scene);
			}
			catch(Exception error){
				
			}
		}
		return 0;
	}
	

}
