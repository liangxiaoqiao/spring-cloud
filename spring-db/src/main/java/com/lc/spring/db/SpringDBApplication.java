package com.lc.spring.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liangchao03
 *         2017/10/26
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringDBApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDBApplication.class, args);
    }
}
