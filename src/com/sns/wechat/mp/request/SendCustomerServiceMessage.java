package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.WeChatResponseMessage;
import com.sns.wechat.mp.response.CommonResponse;
/**
 * 发送客服消息
 * 当用户主动发消息给公众号的时候（包括发送信息、点击自定义菜单、订阅事件、扫描二维码事件、支付成功事件、用户维权）
 * 开发者在一段时间内（目前修改为48小时）可以调用客服消息接口，不限制发送次数。
 * @author Tian Zhiyuan
 * @date 2014年10月11日
 * @version 0.1
 */
@RequestMethod(Method.POST)
@RequestPath("/cgi-bin/message/custom/send")
public class SendCustomerServiceMessage extends RequestAccessed<CommonResponse> {

	/**
	 * 待发送的消息,支持：
	 * 		文本、图片、语音、视频、图文
	 */
	private WeChatResponseMessage message;

	public WeChatResponseMessage getMessage() {
		return message;
	}

	public void setMessage(WeChatResponseMessage message) {
		this.message = message;
	}
	@Override
	public String getData(){
		return toJson(message);
	}
}
