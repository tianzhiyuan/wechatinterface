package com.sns.wechat.mp.bean;

import com.sns.wechat.mp.WeChatOAuthBuilder;
import com.sns.wechat.mp.enumpackage.ButtonType;

/**
 * 自定义菜单按钮类型
 * name 和 type必填，如果type==click,key必填；如果type==view，url必填；
 * 如果type==parent，sub_button必填
 * @author Tian Zhiyuan
 *
 */
public class Button {
	/**
	 * 菜单名称 必填
	 */
	private String name;
	/**
	 * 子按钮
	 */
	private Button[] sub_button;
	/**
	 * 按钮类型
	 */
	private ButtonType type;
	/**
	 * 跳转的url，绝对地址
	 */
	private String url;
	/**
	 * EventKey值
	 */
	private String key;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ButtonType getType() {
		return type;
	}
	public void setType(ButtonType type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 将Url设置为带网页授权的地址
	 * @param url 源Url地址，必须为绝对地址
	 * @param appid 微信公众号appid
	 */
	public void setOAuthUrl(String url, String appid){
		this.url = WeChatOAuthBuilder.BuildBaseUrl(appid, url);
	}
	

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
