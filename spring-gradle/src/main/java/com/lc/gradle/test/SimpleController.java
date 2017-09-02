package com.lc.gradle.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.lc.gradle.convert.UserDeserializer;
import com.lc.gradle.convert.UserModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by liangchao03 on 2017/6/15.
 */
//@EnableDiscoveryClient
@RestController
public class SimpleController {

    private final Logger log = Logger.getLogger(getClass().toString());

    @Autowired
    private User user;
    @Autowired
    private MyRandom random;

    @Autowired
    private DiscoveryClient client;

    /**
     * it will return a string that contains the name you gived.
     * @param name the value that after the Hello.
     * @return This will return the value Hello  @param name!
     */
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(name = "name",required = false,defaultValue = "Gradle")String name){
        ServiceInstance instance = client.getLocalServiceInstance();

        log.info("/hello,host:"+instance.getHost()+", service id:"+client.getServices());
        return "Hello "+name+"!";
    }

    /**
     *
     * @return it is just return a list contains 3 string.
     */
    @RequestMapping("/test")
    public List test(){
        List<String> list = new ArrayList<>();
        list.add("Test");
        list.add("Gradle");
        list.add("!");
        return list;
    }

    /**
     * if you give none param, the User eneity will get the param from the config
     * @see User
     * @param name the name of user
     * @param age the age of user
     * @param desc the desc of user
     * @return User entity
     */
    @RequestMapping("/user")
    public User user(@RequestParam(name="id",required = false)Integer id,@RequestParam(name = "name",required = false)String name,@RequestParam(name = "age",defaultValue = "404")String age,@RequestParam(name="desc",required = false)String desc){
        if(id != null){
            user.setId(id);
        }
        if(name != null){
            user.setName(name);
        }
        //return getUser();
        if(age != null){
            user.setAge(Integer.parseInt(age));
        }

        if(desc != null){
            user.setDesc(desc);
        }
        return user;
    }

    /**
     * @return  a MyRandom entity, all of its params were come from config
     */
    @RequestMapping("/random")
    public MyRandom random(){
        //return getRandom();
        return random;
    }

    @PostMapping("/postuser")
    public User user(@RequestBody User user){
        System.out.println(this.getClass()+" "+user);
        return user;
    }
}