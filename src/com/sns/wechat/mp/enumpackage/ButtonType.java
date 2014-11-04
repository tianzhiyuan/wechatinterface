package com.sns.wechat.mp.enumpackage;

/**
 * 微信自定义菜单按钮类型
 * @author Tian Zhiyuan
 *
 */
public enum ButtonType {
	/**
	 * 父按钮
	 */
	parent("parent"),
	/**
	 * 点击按钮
	 */
	click("click"),
	/**
	 * 浏览网址按钮
	 */
	view("view");
	private String oType;
	private ButtonType(String oType){
		this.oType = oType;
	}
	@Override
	public String toString(){
		return this.oType;
	}
}
