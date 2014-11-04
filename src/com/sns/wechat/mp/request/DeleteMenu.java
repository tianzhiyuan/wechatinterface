package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.CommonResponse;
/**
 * 删除用户分组
 * @author Tian Zhiyuan
 *
 */
@RequestMethod(Method.POST)
@RequestPath("/cgi-bin/menu/delete")
public class DeleteMenu extends RequestAccessed<CommonResponse> {
	
}
