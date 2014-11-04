package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestBase;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.enumpackage.LangType;
import com.sns.wechat.mp.response.UserInfoResponse;
/**
 * 网页授权获取用户基本信息
 * @author Tian Zhiyuan
 *
 */
@RequestPath(value = "/sns/userinfo")
public class GetOAuthUserInfo extends RequestBase<UserInfoResponse> {
	private String accessToken;
	private String openid;
	private LangType lang = LangType.zh_CN;
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getOpenid() {
		return openid;
	}
	/**
	 * @param openid 用户的唯一标识
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public LangType getLang() {
		return lang;
	}
	/**
	 * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认zh_CN
	 */
	public void setLang(LangType lang) {
		this.lang = lang;
	}
	@Override
	public String getParam(){
		return String.format("access_token=%s&openid=%s&lang=%s", this.accessToken, this.openid, this.lang.toString());
	}
}
