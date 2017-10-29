package com.lc.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by LC on 2017/6/17.
 */

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class SpringRibbonApplication {

    public static void main(String[] args){
        SpringApplication.run(SpringRibbonApplication.class,args);
    }
}
