package com.sns.wechat.mp.response;
import com.sns.wechat.mp.ResponseBase;
import com.sns.wechat.mp.bean.UserGroup;

/**
 * 创建用户组返回类型
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
public class CreateUserGroupResponse extends ResponseBase{
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
	
}
