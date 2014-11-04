package com.sns.wechat.mp.request;

import com.sns.wechat.mp.RequestAccessed;
import com.sns.wechat.mp.RequestMethod;
import com.sns.wechat.mp.RequestMethod.Method;
import com.sns.wechat.mp.RequestPath;
import com.sns.wechat.mp.bean.Menu;
import com.sns.wechat.mp.response.CommonResponse;
/**
 * 创建自定义菜单接口
 * 
 * @author Tian Zhiyuan
 */
@RequestMethod(Method.POST)
@RequestPath("/cgi-bin/menu/create")
public class CreateMenu extends RequestAccessed<CommonResponse> {
	/**
	 * 需要创建的菜单
	 */
	private Menu menu;
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	@Override
	public String getData(){
		return toJson(this.menu);
	}
}
