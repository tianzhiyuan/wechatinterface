/**
 * 
 */
package com.sns.wechat.mp.respmsg;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.sns.wechat.mp.WeChatResponseMessage;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 回复文本消息
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
@XmlRootElement(name = "xml")
public class TextMessage extends WeChatResponseMessage {

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
		return WeChatMessageType.TEXT.toString();
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonIgnore
	private String content;

	@JsonProperty("text")
	public TextContent getTextContent(){
		TextContent c = new TextContent();
		c.setContent(this.content);
		return c;
	}
	@Override
	protected String WriteLocal() {
		// TODO Auto-generated method stub
		return Write("Content", content);
	}
	public class TextContent{
		@JsonProperty("content")
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
}
