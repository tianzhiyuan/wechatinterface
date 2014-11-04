package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.bean.NewsArticle;
import com.sns.wechat.mp.response.UploadResponse;
/**
 * 上传图文消息素材
 * 群发消息时，需要首先调用此接口讲图文上传。
 * @author Tian Zhiyuan
 *
 */
@RequestPath("/cgi-bin/media/uploadnews")
@RequestMethod(Method.POST)
public class UploadNews extends RequestAccessed<UploadResponse> {
	/**
	 * 需要上传的图文消息
	 */
	private NewsArticle[] articles;
	@Override
	public String getData(){
		return toJson(this);
	}
	public NewsArticle[] getArticles() {
		return articles;
	}
	public void setArticles(NewsArticle[] articles) {
		this.articles = articles;
	}
}
