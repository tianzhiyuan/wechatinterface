package com.sns.wechat.mp.enumpackage;

/**
 * 微信网页认证授权域
 * @author Tian Zhiyuan
 *
 */
public enum WeChatOAuthScope {
	/**
	 * 只能获取到openid
	 */
	SNSAPI_BASE("snsapi_base"),
	/**
	 * 能获取到openid及用户信息
	 */
	SNSAPI_USERINFO("snsapi_userinfo"),
	/**
	 * 网页应用授权登录
	 */
	SNSAPI_LOGIN("snsapi_login");
	
	private String scope;
	private WeChatOAuthScope(String oType){
		this.scope = oType;
	}
	@Override
	public String toString(){
		return this.scope;
	}
}
