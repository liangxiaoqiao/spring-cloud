package com.lc.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liangchao on 17-10-29.
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "ribbonIdFallBack")
    public String ribbonId(String path1,String path2,String id){
        ResponseEntity entity=  template.getForEntity("http://DB-ONE-SERVICE/"+path1+"/"+path2+"?id="+id,Object.class);
        return entity.getBody().toString();
    }


    @HystrixCommand(fallbackMethod = "ribbonIdFallBack")
    public String ribbonName(String path1,String path2,String name){
        ResponseEntity entity=  template.getForEntity("http://DB-ONE-SERVICE/"+path1+"/"+path2+"?name="+name,Object.class);
        return entity.getBody().toString();
    }

    @HystrixCommand(fallbackMethod = "myfallback")
    public String ribbon(){
        ResponseEntity entity=  template.getForEntity("http://DB-ONE-SERVICE/book/id?id=1",Object.class);
        return entity.getBody().toString();
    }


    @HystrixCommand(fallbackMethod = "myfallback2")
    public String ribbon2(Long id){
        ResponseEntity entity=  template.getForEntity("http://DB-ONE-SERVICE/book/id?id=1",Object.class);
        return entity.getBody().toString();
    }

    @HystrixCommand(fallbackMethod = "fallbackAgain2")
    public String myfallback2(Long id){
        throw new RuntimeException("myfallback2自定义抛出异常");
    }

    public String fallbackAgain2(Long id, Throwable e){
        System.out.println(e.getMessage());
        return "ribbon2 第二次降级服务";
    }

    @HystrixCommand(fallbackMethod = "fallbackAgain1")
    public String myfallback(){
        throw new RuntimeException("myfallback抛出异常");
    }

    public String fallbackAgain1(Throwable e){
        System.out.println(e.getMessage());
        return "ribbon1 第二次降级服务";
    }


    public String ribbonIdFallBack(String path1,String path2,String id){
        Map map = new HashMap<String,String>();
        map.put("path1",path1);
        map.put("path2",path2);
        map.put("id",id);
        return "fall back "+map;
    }
}
