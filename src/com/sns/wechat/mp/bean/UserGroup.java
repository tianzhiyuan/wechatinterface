package com.sns.wechat.mp.bean;

/**
 * 用户组
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
public class UserGroup {
	/**
	 * 用户组id，微信分配
	 */
	private int id;
	/**
	 * 用户组名称
	 */
	private String name;
	/**
	 * 用户组下包含的用户数量
	 */
	private int count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString(){
		return String.format("id:%d, count:%d, name:'%s'",  id, count, name);
	}
}
