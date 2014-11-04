package com.sns.wechat.mp.request;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.CreateShortUrlResponse;

/**
 * 将一条长链接转成短链接。
 * 主要使用场景： 开发者用于生成二维码的原链接（商品、支付二维码等）太长导致扫码速度和成功率下降，
 * 将原长链接通过此接口转成短链接再生成二维码将大大提升扫码速度和成功率。
 * @author Tian Zhiyuan
 * @date 2014年10月15日
 * @version 0.1
 */
@RequestMethod(Method.POST)
@RequestPath("/cgi-bin/shorturl")
public class CreateShortUrl extends RequestAccessed<CreateShortUrlResponse> {
	public CreateShortUrl(){
		this.action = "long2short";
	}
	/**
	 * 默认为long2short，代表长链接转短链接
	 */
	@JsonProperty("action")
	private String action;
	/**
	 * 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
	 */
	@JsonProperty("long_url")
	private String longUrl;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	@Override
	public String getData(){
		return toJson(this);
	}
}
