package com.sns.wechat.mp.response;
import com.sns.wechat.mp.ResponseBase;

/**
 * 获取所属用户组返回类型
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
public class GetBelongGroupResponse extends ResponseBase {
	/**
	 * 所属用户组id
	 */
	private int groupid;

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
}
