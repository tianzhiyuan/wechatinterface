package com.sns.wechat.mp.recvmsg;

import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 微信音频消息
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatVoiceMsg extends WeChatMediaMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.dbcsoft.shopping.service.local.wechat.WeChatBaseMsg#getMsgType()
	 */
	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return WeChatMessageType.VOICE.toString();
	}

	/**
	 * 语音格式，如amr，speex等
	 */
	private String format;
	/**
	 * 开通语音识别功能，用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，增加一个Recongnition字段。
	 */
	private String recognition;

	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	
}
