package com.lc.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liangchao on 17-10-29.
 */
@RestController
public class RibbonController {
    @Autowired
    private RestTemplate template;

    @RequestMapping("/ribbon")
    public String ribbon(@RequestParam String id){
        return template.getForEntity("http://DB-ONE-SERVICE/book/id?id="+id,String.class).getBody();
    }
}
