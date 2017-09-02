package com.lc.ribbon.service;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by LC on 2017/6/18.
 */
@Service
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * use @see {@link HystrixCommand} to execute http;//HELLO-SERVICE/hello?desc={1},the desc param is "hystrix(from service)"
     */
    @HystrixCommand(fallbackMethod = "consumerFallBack")
    public String consumerService(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello?desc={1}",String.class,"hystrix(from service)").getBody();
    }

    /**
     * if could not visit the service, it will use this method.
     */
    public String consumerFallBack(){
        return "error";
    }
}
