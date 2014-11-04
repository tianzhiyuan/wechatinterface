package com.sns.wechat.mp.response;
import java.net.URLEncoder;

import com.sns.wechat.mp.ResponseBase;


/**
 * 创建二维码返回值
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
public class CreateQrTicketResponse extends ResponseBase{
	/**
	 * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	 */
	private String ticket;
	/**
	 * 二维码的有效时间，以秒为单位。最大不超过1800 临时二维码时有效
	 */
	private int expire_seconds;
	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 */
	private String url;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 用ticket换取二维码图片
	 * @param ticket ticket
	 * @return 二维码图片地址
	 */
	public static String getQrImageUrl(String ticket){
		try{
			return String.format("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s", URLEncoder.encode(ticket, "UTF-8"));
		}
		catch(Exception error){
			error.printStackTrace();
			return String.format("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s", ticket);
		}
	}
}
