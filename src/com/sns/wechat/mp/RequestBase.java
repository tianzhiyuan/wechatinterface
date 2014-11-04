package com.sns.wechat.mp;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.sns.wechat.mp.RequestMethod.Method;
/**
 * 微信接口请求基类
 * @author Tian Zhiyuan
 * */
@RequestMethod(Method.GET)
public  class RequestBase<TResponse extends ResponseBase>{
	

	private JsonSerializer json;
	


	
	
	/**
	 * @return 请求参数，拼接到url上，例如 access_token=ACCESS_TOKEN
	 */
	@JsonIgnore
	public String getParam(){
		return "";
	}
	/**
	 * @return POST Data 一般是一段json格式数据
	 */
	@JsonIgnore
	public String getData(){
		return "";
	}
	
	/**
	 * 将一个对象转化成json字符串
	 * @param obj 待转化的对象
	 * @return json字符串
	 */
	@JsonIgnore
	protected String toJson(Object obj){
		json = (JsonSerializer)ServiceLocator.getBean(JsonSerializer.class);
		return json.serialize(obj);
	}
}
