package com.sns.wechat.mp;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 需要应用登录状态的微信API调用请求基类
 * @author Tian Zhiyuan
 *
 * @param <TResponse> 回复类型
 */
public abstract class RequestAccessed<TResponse extends ResponseBase> extends RequestBase<TResponse> {
	/**
	 * Access Token 公众号接口调用票据
	 */
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	@Override
	@JsonIgnore
	public String getParam(){
		return "access_token="+this.accessToken;
	}
}
