package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestBase;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.GetOpenIdByCodeResponse;
/**
 * 微信网页授权接口，根据回调中获取到的code，拿到openid
 * @author Tian Zhiyuan
 *
 */
@RequestPath("/sns/oauth2/access_token")
public class GetOpenIdByCode extends RequestBase<GetOpenIdByCodeResponse> {
	/**
	 * 微信公众号appid
	 */
	private String appId;
	/**
	 * 微信公众号secret
	 */
	private String appSecret;
	/**
	 * 网页授权回调中返回的code字段
	 */
	private String code;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String getParam(){
		return String.format("appid=%s&secret=%s&code=%s&grant_type=authorization_code", this.appId,this.appSecret, this.code);
	}
}
