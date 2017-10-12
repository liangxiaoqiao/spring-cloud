package com.lc.spring.cloud.zuul.api.gateway;

import com.lc.spring.cloud.zuul.api.gateway.filter.AccessFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by LC on 2017/6/19.
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayApplication.class, args);
    }



//    @Autowired
//    AccessFilter filter;

    //两种自动注入都可以
    @Bean
    AccessFilter getFilter(){
        return new AccessFilter();
    }
}
