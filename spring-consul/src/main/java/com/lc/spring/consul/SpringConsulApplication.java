package com.lc.spring.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangchao03
 *         2017/10/23
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class SpringConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringConsulApplication.class,args);
    }
}
