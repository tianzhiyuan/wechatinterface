package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.response.CommonResponse;
/**
 * 设置用户备注
 * @author Tian Zhiyuan
 *
 */
@RequestPath("/cgi-bin/user/info/updateremark")
@RequestMethod(Method.POST)
public class SetUserRemark extends RequestAccessed<CommonResponse> {
	/**
	 * 用户openid
	 */
	private String openid;
	/**
	 * 备注名称
	 */
	private String remark;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String getData(){
		return String.format("{'openid':'%s', 'remark':'%s'}", this.openid, this.remark).replace('\'', '"');
	}
}
