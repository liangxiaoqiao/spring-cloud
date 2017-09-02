package com.lc.gradle.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.lc.gradle.test.User;

import java.io.IOException;

/**
 * Created by liangchao03 on 2017/6/27.
 */
    public class UserSerializer extends JsonSerializer<User>{

    @Override
    public void serialize(User value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        System.out.println(this.getClass()+" " + value);
        gen.writeString("{\"\u000F\u0008\r\t\f\u0000serialize\":\"value\"}");
    }

    @Override
    public Class<User> handledType() {
        return User.class;
    }
}
