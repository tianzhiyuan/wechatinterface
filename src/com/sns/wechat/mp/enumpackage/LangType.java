package com.sns.wechat.mp.enumpackage;

/**
 * 微信语言类型
 * @author Tian Zhiyuan
 *
 */
public enum LangType {
	/**
	 * 中文简体
	 */
	zh_CN("zh_CN"),
	/**
	 * 中文繁体
	 */
	zh_TW("zh_TW"),
	/**
	 * 英文
	 */
	en("en");
	private String oType;
	private LangType(String oType){
		this.oType = oType;
	}
	@Override
	public String toString(){
		return this.oType;
	}
}
