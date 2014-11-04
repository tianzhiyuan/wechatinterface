package com.sns.wechat.mp.bean;

import java.util.ArrayList;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 图文消息
 * 注意这里只实现了自定义的json序列化器，如果需要反序列化，也需要实现自定义的反序列化器
 * @author Tian Zhiyuan
 * @date 2014年10月14日
 * @version 0.1
 */
@JsonSerialize(using = ArticlesJsonConverter.class)
public class Articles extends ArrayList<ArticleItem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
