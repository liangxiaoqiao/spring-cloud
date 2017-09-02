package com.lc.feign.consumer.hello.controller;

import com.lc.feign.consumer.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liangchao03 on 2017/6/19.
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/feign-consumer")
    public String feignConsumer(){
        return helloService.hello();
    }

}
