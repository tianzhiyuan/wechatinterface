package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.GetAllUserGroupResponse;
/**
 * 获取所有用户分组
 * @author Tian Zhiyuan
 *
 */
@RequestPath("/cgi-bin/groups/get")
public class GetAllUserGroup extends RequestAccessed<GetAllUserGroupResponse> {
	
}
