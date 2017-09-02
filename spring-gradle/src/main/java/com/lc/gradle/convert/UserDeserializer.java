package com.lc.gradle.convert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.lc.gradle.test.User;

import java.io.IOException;

/**
 * Created by liangchao03 on 2017/6/27.
 */
public class UserDeserializer extends JsonDeserializer {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String text = p.getText();
        System.out.println(this.getClass()+ " "+text);
        return User.builder().id(111).name("111").age(111).desc("deseriazlier  111").build();
    }
}
