package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatEventType;

/**
 * 用户扫描事件
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatScanQrEvent extends WeChatEventMsg implements Serializable {

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
		return WeChatEventType.EVENT_SCAN.toString();
	}

	/**
	 * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id，例如qrscene_100
	 */
	private String eventKey;
	/**
	 * 二维码的ticket，可用来换取二维码图片
	 */
	private String ticket;

	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
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
