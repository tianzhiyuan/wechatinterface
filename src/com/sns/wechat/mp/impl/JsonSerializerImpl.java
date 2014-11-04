package com.sns.wechat.mp.impl;

import java.io.StringWriter;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.sns.wechat.mp.JsonSerializer;


public class JsonSerializerImpl implements JsonSerializer{
	private static ObjectMapper mapper;
	private synchronized static ObjectMapper getMapper(){
		if(mapper == null){
			mapper = new ObjectMapper();
			//序列化时，忽略null值
			mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
			//反序列化时忽略bean中未定义的字段
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
		return mapper;
	}
	public String serialize(Object obj){
		StringWriter sw = new StringWriter();
		ObjectMapper mapper = getMapper();
		try{
			mapper.writeValue(sw, obj);
		}
		catch(Exception error){
			error.printStackTrace();
		}
		return sw.toString();
	}
	
	public Object deserialize(Class<?> cls, String json){
		ObjectMapper mapper = getMapper();
		try{
			return mapper.readValue(json, cls);
		}
		catch(Exception error){
			error.printStackTrace();
		}
		return null;
	}
}
