/**
 * 
 */
package com.sns.wechat.mp.respmsg;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sns.wechat.mp.WeChatResponseMessage;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 回复视频消息
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
@XmlRootElement(name = "xml")
public class VideoMessage extends WeChatResponseMessage {

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
		return WeChatMessageType.VIDEO.toString();
	}
	
	public VideoContent getVideo() {
		return video;
	}
	public void setVideo(VideoContent video) {
		this.video = video;
	}

	public class VideoContent{
		private String mediaId;
		private String title;
		private String description;
		private String thumbMediaId;
		@JsonProperty("media_id")
		public String getMediaId() {
			return mediaId;
		}
		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
		@JsonProperty("title")
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		@JsonProperty("description")
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@JsonProperty("thumb_media_id")
		public String getThumbMediaId() {
			return thumbMediaId;
		}
		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}
		
	}
	@JsonProperty("video")
	private VideoContent video;

	@Override
	protected String WriteLocal() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append(Write("MediaId", video.getMediaId()));
		buffer.append(Write("Title", video.getTitle()));
		buffer.append(Write("Description", video.getDescription()));
		
		return Write("Video", buffer.toString());
	}
	
}
