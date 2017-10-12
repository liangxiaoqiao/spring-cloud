package com.lc.feign.consumer.hello.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.ServiceMode;

/**
 * Created by liangchao03 on 2017/6/19.
 */
@FeignClient("hello-service")
public interface HelloService {
    @RequestMapping("/hello")
    String hello();
}
