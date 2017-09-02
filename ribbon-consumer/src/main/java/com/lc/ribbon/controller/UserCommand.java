package com.lc.ribbon.controller;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * Created by LC on 2017/6/18.
 */
public class UserCommand extends HystrixCommand<User> {
    private RestTemplate template;
    private Integer id;
    private String desc;

    protected UserCommand(Setter setter,RestTemplate restTemplate,Integer id,String desc) {
        super(setter);
        this.template = restTemplate;
        this.id = id;
        this.desc = desc;
    }


    @Override
    protected User run() throws Exception {
        return template.getForObject("http://HELLO-SERVICE/user?id={1}&desc={2}",User.class,id,desc);
    }


    @Override
    protected User getFallback() {
        return User.builder().desc("fall back desc").build();
    }
}
