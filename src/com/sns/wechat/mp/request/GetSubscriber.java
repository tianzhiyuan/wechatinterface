package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.GetSubscriberResponse;
/**
 * 获取关注着列表
 * 注意：当公众号关注者数量超过10000时，可通过填写next_openid的值，从而多次拉取列表的方式来满足需求。
 * @author Tian Zhiyuan
 *
 */
@RequestPath("/cgi-bin/user/get")
public class GetSubscriber extends RequestAccessed<GetSubscriberResponse> {
	/**
	 * 第一个拉取的OPENID，不填默认从头开始拉取
	 */
	private String nextOpenId;

	public String getNextOpenId() {
		return nextOpenId;
	}

	public void setNextOpenId(String nextOpenId) {
		this.nextOpenId = nextOpenId;
	}
	@Override
	public String getParam(){
		if(this.nextOpenId == null || this.nextOpenId == ""){
			return "access_token="+this.getAccessToken();
		}
		return String.format("access_token=%s&next_openid=%s", this.getAccessToken(), this.getNextOpenId());
	}
}
