/**
 * 
 */
package com.sns.wechat.mp.respmsg;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sns.wechat.mp.WeChatResponseMessage;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 语音消息
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
@XmlRootElement(name = "xml")
public class VoiceMessage extends WeChatResponseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.dbcsoft.shopping.service.local.wechat.WeChatBaseMsg#getMsgType()
	 */
	@Override
	@JsonProperty("msgtype")
	public String getMsgType() {
		// TODO Auto-generated method stub
		return WeChatMessageType.VOICE.toString();
	}

	
	public VoiceContent getVoice() {
		return voice;
	}
	public void setVoice(VoiceContent voice) {
		this.voice = voice;
	}

	public class VoiceContent{
		@JsonProperty("media_id")
		private String mediaId;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
		
	}
	@JsonProperty("voice")
	private VoiceContent voice;

	@Override
	protected String WriteLocal() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append(Write("MediaId", voice.getMediaId()));
		
		return WriteObject("Voice", buffer.toString());
	}
	
}
