package com.sns.wechat.mp;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 微信公众号请求方式，POST或GET
 * @author Tian Zhiyuan
 * @date 2014年10月15日
 * @version 0.1
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RequestMethod {
	public enum Method{
		POST,
		GET;
	}
	Method value();
}
