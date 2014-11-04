package com.sns.wechat.mp.response;
import com.sns.wechat.mp.ResponseBase;

/**
 * 上传资源返回类型
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
public class UploadResponse extends ResponseBase {
	/**
	 * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），次数为news，即图文消息
	 */
	private String type ;
	/**
	 * 媒体文件/图文消息上传后获取的唯一标识
	 */
	private String media_id ;
	/**
	 * 媒体文件上传时间
	 */
	private long created_at ;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public long getCreated_at() {
		return created_at;
	}
	public void setCreated_at(long created_at) {
		this.created_at = created_at;
	}
	
	
}
