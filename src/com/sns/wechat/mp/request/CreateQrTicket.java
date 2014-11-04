package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.enumpackage.QrTicketType;
import com.sns.wechat.mp.response.CreateQrTicketResponse;



/**
 * 创建推广二维码
 * https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET 获取二维码图片
 * @author Tian Zhiyuan
 *
 */
@RequestMethod(RequestMethod.Method.POST)
@RequestPath("/cgi-bin/qrcode/create")
public class CreateQrTicket extends RequestAccessed<CreateQrTicketResponse> {

	/**
	 * 场景值
	 */
	private int sceneId;
	/**
	 * 过期时间，临时二维码需要填写
	 */
	private int expireSeconds;
	/**
	 * 二维码类型,默认为永久二维码
	 */
	private QrTicketType ticketType = QrTicketType.PERMANENT_QR;
	
	public int getSceneId() {
		return sceneId;
	}
	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	public int getExpireSeconds() {
		return expireSeconds;
	}
	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
	public QrTicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(QrTicketType ticketType) {
		this.ticketType = ticketType;
	}
	
	@Override
	public String getData(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		if(this.ticketType == QrTicketType.TEMP_QR){
			buffer.append("'expire_seconds':"+this.expireSeconds+",");
		}
		buffer.append("'action_name':'" + this.ticketType.toString()+"',");
		buffer.append("'action_info':{'scene':{'scene_id':" + this.sceneId+"}}");
		buffer.append("}");
		return buffer.toString().replace('\'', '"');
	}
}
