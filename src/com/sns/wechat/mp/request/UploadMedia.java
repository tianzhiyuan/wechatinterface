package com.sns.wechat.mp.request;

import java.io.InputStream;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.enumpackage.WeChatMediaType;
import com.sns.wechat.mp.response.UploadResponse;

/**
 * 上传多媒体文件
 * @author Tian Zhiyuan
 * @date 2014年10月11日
 * @version 0.1
 */
@RequestMethod(Method.POST)
@RequestPath(value = "http://file.api.weixin.qq.com/cgi-bin/media/upload", isFullPath = true)
public class UploadMedia extends RequestAccessed<UploadResponse> {
	/**
	 * 多媒体文件类型
	 */
	private WeChatMediaType mediaType;
	/**
	 * 多媒体文件输入流
	 */
	private InputStream inputStream;
	/**
	 * 文件名称
	 */
	private String fileName;
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public WeChatMediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(WeChatMediaType mediaType) {
		this.mediaType = mediaType;
	}

	@Override
	public String getParam(){
		return String.format("access_token=%s&type=%s", this.getAccessToken(), this.mediaType.toString());
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * 获取媒体文件下载地址
	 * @param accessToken 
	 * @param mediaId
	 * @return
	 */
	public static String getDownloadUrl(String accessToken, String mediaId){
		return String.format("http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", accessToken, mediaId);
	}
}
