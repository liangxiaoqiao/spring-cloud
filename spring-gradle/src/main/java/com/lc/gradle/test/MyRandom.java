package com.lc.gradle.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by liangchao03 on 2017/6/15.
 */

@Component
public class MyRandom {
    @Value("${com.didispace.blog.value}")
    private String value;

    @Value("${com.didispace.blog.int}")
    private String intValue;

    @Value("${com.didispace.blog.long}")
    private String longValue;

    @Value("${com.didispace.blog.test1}")
    private String less10;

    @Value("${com.didispace.blog.test2}")
    private String from10To20;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIntValue() {
        return intValue;
    }

    public void setIntValue(String intValue) {
        this.intValue = intValue;
    }

    public String getLongValue() {
        return longValue;
    }

    public void setLongValue(String longValue) {
        this.longValue = longValue;
    }

    public String getLess10() {
        return less10;
    }

    public void setLess10(String less10) {
        this.less10 = less10;
    }

    public String getFrom10To20() {
        return from10To20;
    }

    public void setFrom10To20(String from10To20) {
        this.from10To20 = from10To20;
    }
}
