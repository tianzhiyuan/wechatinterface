package com.sns.wechat.mp.response;
import com.sns.wechat.mp.ResponseBase;
import com.sns.wechat.mp.bean.OpenIdList;

/**
 * 获取关注着列表返回值
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
public class GetSubscriberResponse extends ResponseBase {
	/**
	 * 关注该公众账号的总用户数
	 */
	private int total ;
	/**
	 * 拉取的OPENID个数，最大值为10000
	 */
	private int count ;
	/**
	 * 列表数据，OPENID的列表
	 */
	private OpenIdList data ;
	/**
	 * 拉取列表的后一个用户的OPENID
	 */
	private String next_openid ;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public OpenIdList getData() {
		return data;
	}
	public void setData(OpenIdList data) {
		this.data = data;
	}
	public String getNext_openid() {
		return next_openid;
	}
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}
	
	
}
