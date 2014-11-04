package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.UploadResponse;
/**
 * 如果想群发视频消息，必须先调用此接口获取media_id
 * 注意接口中的media_id需通过基础支持中的上传下载多媒体文件来得到 {@link UploadMedia}
 * @author Tian Zhiyuan
 *
 */
@RequestPath("/cgi-bin/media/uploadvideo")
@RequestMethod(Method.POST)
public class UploadVideo extends RequestAccessed<UploadResponse> {
	/**
	 * 媒体文件/图文消息上传后获取的唯一标识
	 */
	private String mediaId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 描述 
	 */
	private String description;
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String getData(){
		return String.format("{'media_id':'%s','title':'%s','description':'%s'}", this.mediaId, this.title, this.description).replace('\'', '"');
	}
}
