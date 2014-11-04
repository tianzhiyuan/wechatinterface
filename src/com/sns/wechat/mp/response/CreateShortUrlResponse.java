/**
 * 
 */
package com.sns.wechat.mp.response;
import com.sns.wechat.mp.ResponseBase;

/**
 * 长连接转短链接结果。
 * @author Tian Zhiyuan
 * @date 2014年10月15日
 * @version 0.1
 */
public class CreateShortUrlResponse extends ResponseBase {
	/**
	 * 短链接
	 */
	private String short_url;

	public String getShort_url() {
		return short_url;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}
}
