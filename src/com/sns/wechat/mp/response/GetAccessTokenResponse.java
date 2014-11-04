package com.sns.wechat.mp.response;
import com.sns.wechat.mp.ResponseBase;


/**
 * 获取AccessToken返回类型
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
public class GetAccessTokenResponse extends ResponseBase {
	/**
	 * 获取到的凭证
	 */
	private String access_token;
	/**
	 * 凭证有效时间，单位：秒
	 */
	private int expires_in;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
}
