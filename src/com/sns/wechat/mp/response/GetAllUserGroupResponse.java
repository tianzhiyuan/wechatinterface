package com.sns.wechat.mp.response;
import com.sns.wechat.mp.ResponseBase;
import com.sns.wechat.mp.bean.UserGroup;

/**
 * 获取所有的用户分组返回类型
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
public class GetAllUserGroupResponse extends ResponseBase {
	/**
	 * 用户分组
	 */
	private UserGroup[] groups;

	public UserGroup[] getGroups() {
		return groups;
	}

	public void setGroups(UserGroup[] groups) {
		this.groups = groups;
	}
	
}
