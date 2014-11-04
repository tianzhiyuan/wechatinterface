package com.sns.wechat.mp;
/**
 * json序列化器
 * @author Tian Zhiyuan
 * @date 2014年10月11日
 * @version 0.1
 */

public interface JsonSerializer {
	
	
	/**
	 * 将一个对象序列化为json字符串
	 * @param obj 待序列化对象
	 * @return json字符串
	 */
	public String serialize(Object obj);
	/**
	 * 将json字符串反序列化为对象
	 * @param cls 对象类型
	 * @param json json字符串
	 * @return 反序列化的对象，如果为null说明反序列化失败
	 */
	public Object deserialize(Class<?> cls, String json);
	
}
