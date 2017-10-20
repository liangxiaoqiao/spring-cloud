package com.lc.gradle.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by liangchao on 17-10-12.
 */
@Data
@ConfigurationProperties(prefix = "user.prop")
public class UserProperties {
    private String env;
    private String key;
    private String value;
    
}
