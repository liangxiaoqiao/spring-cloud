package com.lc.gradle.user;

import com.lc.gradle.config.UserAsParamTestBean;
import com.lc.gradle.config.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by liangchao on 17-10-12.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/id/{id}")
    public User getById(@PathVariable Integer id){
         Optional<User> optional = userService.findById(id);
         if(optional.isPresent()){
             return optional.get();
         }
         return new User();
    }

    @RequestMapping("/name/{name}")
    public List<User> getByName(@PathVariable String name){
        Optional<List<User>> optional = userService.findByName(name);
        if(optional.isPresent()){
            return optional.get();
        }
        return new ArrayList<>();
    }

    @RequestMapping(value = "/school", method = {RequestMethod.POST,RequestMethod.GET})
    public List<User> getBySchool(@RequestParam(value = "school")String school){
        Optional<List<User>> optional = userService.findBySchool(school);
        if(optional.isPresent()){
            return optional.get();
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/birth",method = {RequestMethod.POST,RequestMethod.GET})
    public List<User> getByBIrth(@RequestParam(value = "start")@DateTimeFormat(pattern="yyyy-MM-dd")LocalDate start,@RequestParam@DateTimeFormat(pattern="yyyy-MM-dd")LocalDate end){
        Optional<List<User>> optional = userService.findByBirthdayBetween(start,end);
        if(optional.isPresent()){
            return optional.get();
        }
        return new ArrayList<>();
    }



    @Autowired
    private UserProperties userProperties;

    @Autowired
    private UserAsParamTestBean userAsParamTestBean;

    //测试从配置读取内容绑定到bean属性
    @RequestMapping(value="/prop")
    public String propFromConfig(){
        return userProperties.toString();
    }

    //测试从配置读取内容绑定到Bean属性，并且从构造参数传入到方法。Configure里边@Bean创建一个Bean
    @RequestMapping(value="/bindbean")
    public String bindBean(){
        return userAsParamTestBean.toString();
    }



}
