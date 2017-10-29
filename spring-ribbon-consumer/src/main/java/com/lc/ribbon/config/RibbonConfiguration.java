package com.lc.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liangchao on 17-10-29.
 */
@Configuration
public class RibbonConfiguration {

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
