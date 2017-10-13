package com.lc.gradle.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
