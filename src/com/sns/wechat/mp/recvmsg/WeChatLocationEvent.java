package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatEventType;

/**
 * 微信上报地理位置事件
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatLocationEvent extends WeChatEventMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double latitude;
	private double longitude;
	private double precision;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getPrecision() {
		return precision;
	}
	public void setPrecision(double precision) {
		this.precision = precision;
	}
	@Override
	public String getEvent(){
		return WeChatEventType.EVENT_LOCATION.toString();
	}

}
