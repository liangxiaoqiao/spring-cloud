package com.lc.spring.db.controller;

import com.lc.spring.db.custom.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private CustomProperties customProperties;

    @RequestMapping("/test")
    public String customLoader(){
        return customProperties.toString();
    }
}
