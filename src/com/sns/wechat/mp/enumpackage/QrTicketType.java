package com.sns.wechat.mp.enumpackage;

/**
 * 二维码类型
 * @author Tian Zhiyuan
 *
 */
public enum QrTicketType {
	/**
	 * 临时二维码
	 */
	TEMP_QR("QR_SCENE"),
	/**
	 * 永久二维码
	 */
	PERMANENT_QR("QR_LIMIT_SCENE");
	
	private String oType;
	private QrTicketType(String oType){
		this.oType = oType;
	}
	@Override
	public String toString(){
		return this.oType;
	}
}
