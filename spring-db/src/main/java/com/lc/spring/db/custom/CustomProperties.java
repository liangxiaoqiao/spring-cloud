package com.lc.spring.db.custom;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.lc")
public class CustomProperties {
    private String id;
    private String name;
}
