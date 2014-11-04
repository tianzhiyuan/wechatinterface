/**
 * 
 */
package com.sns.wechat.mp.respmsg;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sns.wechat.mp.WeChatResponseMessage;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;

/**
 * 转发客服消息
 * 回复此消息之后，粉丝后续发送的所有消息都会直接送达到客服软件中（知道客服会话关闭），而不会post到回调服务器中，请小心使用
 * 注意此时所有发送客服消息接口都不能使用
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
@XmlRootElement(name = "xml")
public class TransferCustomerMessage extends WeChatResponseMessage {

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
		return WeChatMessageType.TRANSFER_CUSTOMER_SERVICE.toString();
	}

	@Override
	protected String WriteLocal() {
		// TODO Auto-generated method stub
		return "";
	}

	
}
