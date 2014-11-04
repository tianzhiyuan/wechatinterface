package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.CreateUserGroupResponse;
/**
 * 创建用户分组
 * @author Tian Zhiyuan
 *
 */
@RequestPath("/cgi-bin/groups/create")
@RequestMethod(Method.POST)
public class CreateUserGroup extends RequestAccessed<CreateUserGroupResponse> {
	/**
	 * 用户组名称
	 */
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String getData(){
		return ("{'group':{'name':'"+this.groupName+"'}}").replace('\'', '"');
	}
}
