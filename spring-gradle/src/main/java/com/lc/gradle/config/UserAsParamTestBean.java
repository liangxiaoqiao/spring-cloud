package com.lc.gradle.config;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by liangchao on 17-10-20.
 */
@Data
public class UserAsParamTestBean {

    private List<String> beanList;
    private Map<String,Object> beanMap;

    public UserAsParamTestBean(UserAsParamProperties prop){
        this.beanList = prop.getDesc();
        this.beanMap = prop.getExt();
    }
}
