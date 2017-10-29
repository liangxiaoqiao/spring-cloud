package com.lc.ribbon.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by liangchao on 17-10-29.
 */
@RestController
public class RibbonController {
    @Autowired
    private RestTemplate template;

    @RequestMapping("/ribbon/{path1}/{path2}")
    public String ribbonId(@PathVariable String path1,@PathVariable String path2,@RequestParam String id){
        ResponseEntity entity=  template.getForEntity("http://DB-ONE-SERVICE/"+path1+"/"+path2+"?id="+id,Object.class);
        return entity.getBody().toString();
    }


    @RequestMapping("/ribbonname/{path1}/{path2}")
    public String ribbonName(@PathVariable String path1,@PathVariable String path2,@RequestParam String name){
        ResponseEntity entity=  template.getForEntity("http://DB-ONE-SERVICE/"+path1+"/"+path2+"?name="+name,Object.class);
        return entity.getBody().toString();
    }
}
