package com.lc.gradle.test;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lc.gradle.convert.UserDeserializer;
import com.lc.gradle.convert.UserSerializer;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by liangchao03 on 2017/6/15.
 */
@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
//@JsonDeserialize(using = UserDeserializer.class)
//@JsonSerialize(using = UserSerializer.class)
public class User {

    private Integer id;

    @Value("${dev.name}")
    private String name;

    @Value("${dev.age}")
    private int age;

    @Value("${dev.desc}")
    private String desc;

}
