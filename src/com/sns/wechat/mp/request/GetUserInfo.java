package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.enumpackage.LangType;
import com.sns.wechat.mp.response.UserInfoResponse;
/**
 * 根据OpenId获取用户信息
 * @author Tian Zhiyuan
 *
 */
@RequestPath("/cgi-bin/user/info")
public class GetUserInfo extends RequestAccessed<UserInfoResponse> {
	/**
	 * 用户openid
	 */
	private String openid;
	/**
	 * 返回的语言类型，默认为zh_CN
	 */
	private LangType lang = LangType.zh_CN;
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public LangType getLang() {
		return lang;
	}

	public void setLang(LangType lang) {
		this.lang = lang;
	}

	@Override
	public String getParam(){
		return String.format("access_token=%s&openid=%s&lang=%s", this.getAccessToken(), this.openid, this.lang.toString());
	}
}
