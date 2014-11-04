package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestBase;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.GetAccessTokenResponse;


/**
 * 获取新的AccessToken
 * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。
 * 正常情况下access_token有效期为7200秒，重复获取将导致上次获取的access_token失效。
 * 由于获取access_token的api调用次数非常有限，需要存储。
 * 公众平台的开发接口的access_token其存储至少要保留512个字符空间
 * @author Tian Zhiyuan
 *
 */
@RequestPath("/cgi-bin/token")
public class GetAccessToken extends RequestBase<GetAccessTokenResponse> {
	/**
	 * 微信公众号appid
	 */
	private String appId;
	/**
	 * 微信公众号secret
	 */
	private String appSecret;
	/**
	 * 授权类型，默认为client_credential，不需要特别设置
	 */
	private String grandType = "client_credential";
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
	public String getGrandType() {
		return grandType;
	}
	public void setGrandType(String grandType) {
		this.grandType = grandType;
	}
	@Override
	public String getParam(){
		return String.format("grant_type=%s&appid=%s&secret=%s", this.grandType, this.appId, this.appSecret);
	}
}
