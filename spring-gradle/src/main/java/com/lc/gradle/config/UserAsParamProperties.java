package com.lc.gradle.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * Created by liangchao on 17-10-20.
 */

@Data
@ConfigurationProperties(prefix = "user.param")
public class UserAsParamProperties {
    private List<String> desc;
    private Map<String,Object> ext;
}
