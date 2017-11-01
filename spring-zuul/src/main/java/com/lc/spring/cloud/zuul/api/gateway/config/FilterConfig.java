package com.lc.spring.cloud.zuul.api.gateway.config;

import com.lc.spring.cloud.zuul.api.gateway.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangchao03
 *         2017/11/1
 */
@Configuration
public class FilterConfig {

    @Bean
    AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
