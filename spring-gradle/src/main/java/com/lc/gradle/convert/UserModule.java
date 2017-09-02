package com.lc.gradle.convert;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.lc.gradle.test.User;

/**
 * Created by liangchao03 on 2017/6/27.
 */
public class UserModule extends SimpleModule {
    public UserModule() {
        addSerializer(new UserSerializer());
        addDeserializer(User.class,new UserDeserializer());
    }

}
