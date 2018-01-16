package com.lc.spring.db.config;

import com.lc.spring.db.custom.CustomProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CustomProperties.class)
public class CustomConfiguration {
}
