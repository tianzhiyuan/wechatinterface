/**
 * 
 */
package com.sns.wechat.mp.respmsg;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.sns.wechat.mp.WeChatResponseMessage;
import com.sns.wechat.mp.bean.ArticleItem;
import com.sns.wechat.mp.bean.Articles;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 回复图文消息
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
@XmlRootElement(name = "xml")
public class NewsMessage extends WeChatResponseMessage {

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
		return WeChatMessageType.NEWS.toString();
	}
	@JsonIgnore
	public int getArticleCount() {
		if(articles == null || articles.isEmpty())return 0;
		return articles.size();
	}

	@JsonProperty("news")
	private Articles articles;
	@Override
	protected String WriteLocal() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append(Write("ArticleCount", getArticleCount()));
		buffer.append("<Articles>");
		for(ArticleItem item :articles){
			StringBuffer itemBuffer = new StringBuffer();
			itemBuffer.append("<item>");
			itemBuffer.append(Write("Title", item.getTitle()));
			itemBuffer.append(Write("Description", item.getDescription()));
			itemBuffer.append(Write("PicUrl", item.getPicUrl()));
			itemBuffer.append(Write("Url", item.getUrl()));
			itemBuffer.append("</item>");
			buffer.append(itemBuffer);
		}
		
		buffer.append("</Articles>");
		return buffer.toString();
	}
	
	public Articles getArticles() {
		return articles;
	}
	public void setArticles(Articles articles) {
		this.articles = articles;
	}
	
}
