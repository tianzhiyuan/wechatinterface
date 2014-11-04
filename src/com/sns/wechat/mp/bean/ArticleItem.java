package com.sns.wechat.mp.bean;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArticleItem {
	@JsonProperty("title")
	public String title;
	@JsonProperty("description")
	public String description;
	@JsonProperty("url")
	public String url;
	@JsonProperty("picurl")
	public String picUrl;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
