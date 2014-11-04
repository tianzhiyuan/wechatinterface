package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.GetBelongGroupResponse;
/**
 * 获取某个用户属于哪个用户组
 * @author Tian Zhiyuan
 *
 */
@RequestMethod(Method.POST)
@RequestPath("/cgi-bin/groups/getid")
public class GetBelongGroup extends RequestAccessed<GetBelongGroupResponse> {
	/**
	 * 用户openid
	 */
	private String openid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Override
	public String getData(){
		return ("{'openid':'"+this.openid+"'}").replace('\'', '"');
	}
	
}
