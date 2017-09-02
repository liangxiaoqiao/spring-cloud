package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by liangchao03 on 2017/6/15.
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {
    public static void main(String[] args) {
      // new SpringApplicationBuilder(Application.class).web(true).run(args);
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
