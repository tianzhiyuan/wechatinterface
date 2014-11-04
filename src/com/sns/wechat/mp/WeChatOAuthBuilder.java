package com.sns.wechat.mp;

import java.net.URLEncoder;

import com.sns.wechat.mp.enumpackage.WeChatOAuthScope;

/**
 * 生成微信OAuth认证url帮助类
 * 
 * @author Tian Zhiyuan
 * @date 2014.10.9
 * @version 0.1
 * */
public class WeChatOAuthBuilder {
	/**
	 * 生成微信OAuth认证url，引导用户打开此url，可以获取当前用户信息。
	 * 
	 * @param scope
	 *            请求域
	 * @param appId
	 *            微信appId
	 * @param redirectUrl
	 *            回调地址，必须是绝对地址（注意不要UrlEncode）
	 * @param state
	 *            选填状态参数，限制为：a-zA-Z0-9用于保持请求和回调的状态
	 * @return OAuth地址
	 * */
	public static String BuildUrl(WeChatOAuthScope scope, String appId,
			String redirectUrl, String state) {
		if (state == null) {
			state = "1";
		}
		String urlFormat = "";
		switch (scope) {
		case SNSAPI_BASE:
		case SNSAPI_USERINFO:
			urlFormat = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";
			break;
		case SNSAPI_LOGIN:
			urlFormat = "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";
			break;
		}
		String encodedUrl = redirectUrl;
		try {
			encodedUrl = URLEncoder.encode(redirectUrl, "UTF-8");
		} catch (Exception error) {
			error.printStackTrace();
		}

		return String.format(urlFormat, appId, encodedUrl, scope.toString(),
				state);
	}

	/*
	 * overloads
	 */
	public static String BuildUrl(WeChatOAuthScope scope, String appId,
			String redirectUrl) {
		return BuildUrl(scope, appId, redirectUrl, null);
	}

	public static String BuildBaseUrl(String appid, String redirectUrl,
			String state) {
		return BuildUrl(WeChatOAuthScope.SNSAPI_BASE, appid, redirectUrl, state);
	}

	public static String BuildUserInfoUrl(String appid, String redirectUrl,
			String state) {
		return BuildUrl(WeChatOAuthScope.SNSAPI_USERINFO, appid, redirectUrl,
				state);
	}

	public static String BuildLoginUrl(String appid, String redirectUrl,
			String state) {
		return BuildUrl(WeChatOAuthScope.SNSAPI_LOGIN, appid, redirectUrl,
				state);
	}

	public static String BuildBaseUrl(String appid, String redirectUrl) {
		return BuildUrl(WeChatOAuthScope.SNSAPI_BASE, appid, redirectUrl, null);
	}

	public static String BuildUserInfoUrl(String appid, String redirectUrl) {
		return BuildUrl(WeChatOAuthScope.SNSAPI_USERINFO, appid, redirectUrl,
				null);
	}

	public static String BuildLoginUrl(String appid, String redirectUrl) {
		return BuildUrl(WeChatOAuthScope.SNSAPI_LOGIN, appid, redirectUrl, null);
	}
}
