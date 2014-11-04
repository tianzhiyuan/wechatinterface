package com.sns.wechat.mp.respmsg;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sns.wechat.mp.WeChatResponseMessage;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;
import com.sun.xml.internal.txw2.annotation.XmlElement;
/**
 * 回复图片消息
 * @author Tian Zhiyuan
 * @date 2014年10月11日
 * @version 0.1
 */
@XmlRootElement(name = "xml")
public class ImageMessage extends WeChatResponseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@XmlElement("MsgType")
	@JsonProperty("msgtype")
	public String getMsgType() {
		// TODO Auto-generated method stub
		return WeChatMessageType.IMAGE.toString();
	}
	@XmlElement("Image")
	public ImageContent getImage() {
		return image;
	}
	public void setImage(ImageContent imageContent){
		this.image = imageContent;
	}
	public void setImage(String mediaId) {
		
		this.image= new ImageContent();
		this.image.setMediaId(mediaId);
	}
	
	public class ImageContent{
		private String mediaId;
		@XmlElement("MediaId")
		@JsonProperty("media_id")
		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
		
	}
	@JsonProperty("image")
	private ImageContent image;

	@Override
	protected String WriteLocal() {
		// TODO Auto-generated method stub
		return WriteObject("Image", Write("MediaId", this.image.getMediaId()));
	}
}
