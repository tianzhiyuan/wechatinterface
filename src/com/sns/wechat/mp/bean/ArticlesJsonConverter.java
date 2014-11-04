package com.sns.wechat.mp.bean;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class ArticlesJsonConverter extends JsonSerializer<Articles>
{

	@Override
	public void serialize(Articles articles, JsonGenerator writer,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		// TODO Auto-generated method stub
		writer.writeStartObject();
        writer.writeFieldName("articles");
        writer.writeStartArray();
        for (ArticleItem item : articles)
        {
            writer.writeStartObject();
            writer.writeStringField("title", item.getTitle());
            writer.writeStringField("description", item.getDescription());
            writer.writeStringField("url", item.getUrl());
            writer.writeStringField("picurl", item.getPicUrl());
            writer.writeEndObject();
        }
        writer.writeEndArray();
        writer.writeEndObject();
	}
    
	
}
