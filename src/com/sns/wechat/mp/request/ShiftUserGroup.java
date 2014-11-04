package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.CommonResponse;
/**
 * 移动用户分组
 * @author Tian Zhiyuan
 *
 */
@RequestMethod(Method.POST)
@RequestPath("/cgi-bin/groups/members/update")
public class ShiftUserGroup extends RequestAccessed<CommonResponse> {
	/**
	 * 用户openid
	 */
	private String openid;
	/**
	 * 目标用户组id
	 */
	private int toGroupId;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getToGroupId() {
		return toGroupId;
	}
	public void setToGroupId(int toGroupId) {
		this.toGroupId = toGroupId;
	}
	@Override
	public String getData(){
		return String.format("{'openid':'%s','to_groupid':%s}", this.openid, this.toGroupId).replace('\'', '"');
	}
}
