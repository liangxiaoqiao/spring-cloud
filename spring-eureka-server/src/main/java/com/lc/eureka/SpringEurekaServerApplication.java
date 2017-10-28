package com.lc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by liangchao03 on 2017/6/15.
 */

@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaServerApplication.class, args);
    }
}
