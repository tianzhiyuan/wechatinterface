package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.bean.UserGroup;
import com.sns.wechat.mp.response.CommonResponse;
/**
 * 更新用户组名称
 * @author Tian Zhiyuan
 *
 */
@RequestMethod(Method.POST)
@RequestPath("/cgi-bin/groups/update")
public class UpdateUserGroupName extends RequestAccessed<CommonResponse>{
	/**
	 * 用户组
	 */
	private UserGroup group;

	public UserGroup getGroup() {
		return group;
	}

	public void setGroup(UserGroup group) {
		this.group = group;
	}
	@Override
	public String getData(){
		return toJson(this);
	}
}
