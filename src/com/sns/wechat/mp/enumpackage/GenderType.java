package com.sns.wechat.mp.enumpackage;

/**
 * 微信返回的性别
 * 
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
public enum GenderType {
	/**
	 * 未知
	 */
	UNKNOWN(0),
	/**
	 * 男性
	 */
	MALE(1),
	/**
	 * 女性
	 */
	FEMALE(2);
	private int type;

	private GenderType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public static GenderType fromInt(int oType) {
		for (GenderType b : GenderType.values()) {
			if (oType == b.type) {
				return b;
			}
		}
		return GenderType.UNKNOWN;
	}
}
