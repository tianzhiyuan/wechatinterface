package com.sns.wechat.mp.request;

import java.util.ArrayList;
import java.util.List;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.enumpackage.WeChatMessageType;
import com.sns.wechat.mp.response.SendMassMessageResponse;

/**
 * 根据openid列表群发消息
 * 
 * @author Tian Zhiyuan
 * @date 2014年10月11日
 * @version 0.1
 */
@RequestMethod(Method.POST)
@RequestPath("/cgi-bin/message/mass/send")
public class SendMassMessage extends RequestAccessed<SendMassMessageResponse> {
	/**
	 * openid 列表
	 */
	private String[] openIds;
	/**
	 * 如果是文本类型，这里传文本内容；如果是其他类型，需要传media_id
	 */
	private String contentOrMediaId;
	/**
	 * 消息类型，支持：
	 * 		文本、图片、语音、视频、图文
	 */
	private WeChatMessageType type;

	public String[] getOpenIds() {
		return openIds;
	}

	public void setOpenIds(String[] openIds) {
		this.openIds = openIds;
	}

	public String getContentOrMediaId() {
		return contentOrMediaId;
	}

	public void setContentOrMediaId(String contentOrMediaId) {
		this.contentOrMediaId = contentOrMediaId;
	}

	@Override
	public String getData() {
		StringBuilder builder = new StringBuilder();
		List<String> openIdList = new ArrayList<String>();
		for(String openid:openIds){
			openIdList.add( "\"" + openid + "\"");
		}
		builder.append('{');
		builder.append(String.format("\"touser\":[%s],", join(openIdList, ',')));
		switch (type) {
		case IMAGE:
			builder.append(String.format("\"image\":{\"meida_id\":\"%s\"},", this.contentOrMediaId));
			builder.append("\"msgtype\":\"image\"");
			break;
		case NEWS:
			builder.append(String.format("\"mpnews\":{\"meida_id\":\"%s\"},", this.contentOrMediaId));
			builder.append("\"msgtype\":\"mpnews\"");
			break;
		case TEXT:
			builder.append(String.format("\"text\":{\"content\":\"%s\"},", this.contentOrMediaId));
			builder.append("\"msgtype\":\"text\"");
			break;
		case VIDEO:
			builder.append(String.format("\"mpvideo\":{\"meida_id\":\"%s\"},", this.contentOrMediaId));
			builder.append("\"msgtype\":\"mpvideo\"");
			break;
		case VOICE:
			builder.append(String.format("\"voice\":{\"meida_id\":\"%s\"},", this.contentOrMediaId));
			builder.append("\"msgtype\":\"voice\"");
			break;
		default:
			return "";

		}
		builder.append('}');
		return builder.toString();
	}

	private static String join(List<String> list, char sep) {
		if (list == null || list.isEmpty())
			return "";
		StringBuilder builder = new StringBuilder();
		for (String str : list) {
			builder.append(str);
			builder.append(sep);
		}
		return builder.substring(0, builder.length() - 1);
	}

	public WeChatMessageType getType() {
		return type;
	}

	public void setType(WeChatMessageType type) {
		this.type = type;
	}
}
