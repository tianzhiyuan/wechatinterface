package com.sns.wechat.mp;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 微信api相对地址
 * @author Tian Zhiyuan
 * @date 2014年10月9日
 * @version 0.1
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestPath {
	String value();
	boolean isFullPath() default false;
}
