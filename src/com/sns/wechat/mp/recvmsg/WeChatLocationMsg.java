package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 微信位置消息
 * @author Tian Zhiyuan
 * @date 2014年10月11日
 * @version 0.1
 */
public class WeChatLocationMsg extends WeChatNormalMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return WeChatMessageType.LOCATION.toString();
	}

	private double location_X;
	private double location_Y;
	private int scale;
	private String label;

	public double getLocation_X() {
		return location_X;
	}
	public void setLocation_X(double location_X) {
		this.location_X = location_X;
	}
	public double getLocation_Y() {
		return location_Y;
	}
	public void setLocation_Y(double location_Y) {
		this.location_Y = location_Y;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
