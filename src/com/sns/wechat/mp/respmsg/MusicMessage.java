/**
 * 
 */
package com.sns.wechat.mp.respmsg;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sns.wechat.mp.WeChatResponseMessage;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 回复音乐消息
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
@XmlRootElement(name = "xml")
public class MusicMessage extends WeChatResponseMessage {

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
		return WeChatMessageType.MUSIC.toString();
	}
	
	public MusicContent getMusic() {
		return music;
	}

	public void setMusic(MusicContent music) {
		this.music = music;
	}

	public class MusicContent{
		        private String title ;
		        
		        private String description ;
		        private String musicUrl;
		        private String hQMusicUrl ;
		        private String thumbMediaId ;
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
				@JsonProperty("musicurl")
				public String getMusicUrl() {
					return this.musicUrl;
				}
				public void setMusicUrl(String musicUrl) {
					this.musicUrl = musicUrl;
				}
				@JsonProperty("hqmusicurl")
				public String getHQMusicUrl() {
					return hQMusicUrl;
				}
				public void setHQMusicUrl(String hQMusicUrl) {
					this.hQMusicUrl = hQMusicUrl;
				}
				@JsonProperty("thumb_media_id")
				public String getThumbMediaId() {
					return thumbMediaId;
				}
				public void setThumbMediaId(String thumbMediaId) {
					this.thumbMediaId = thumbMediaId;
				}
		        
	}
	@JsonProperty("music")
	private MusicContent music;

	@Override
	protected String WriteLocal() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append(Write("Title", music.getTitle()));
		buffer.append(Write("Description", music.getDescription()));
		buffer.append(Write("MusicUrl", music.getMusicUrl()));
		buffer.append(Write("HQMusicUrl", music.getHQMusicUrl()));
		buffer.append(Write("ThumbMediaId", music.getThumbMediaId()));
		return WriteObject("Music", Write("", buffer.toString()));
	}
	
}
