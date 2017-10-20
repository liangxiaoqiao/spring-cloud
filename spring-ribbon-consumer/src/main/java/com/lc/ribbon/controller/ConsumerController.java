//package com.lc.ribbon.controller;
//
//import com.lc.ribbon.service.ConsumerService;
//import com.netflix.governator.annotations.binding.Request;
//import com.netflix.hystrix.HystrixCommandGroupKey;
//import com.netflix.hystrix.HystrixCommandKey;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import static io.reactivex.netty.protocol.http.sse.ServerSentEvent.Type.Data;
//
///**
// * Created by LC on 2017/6/17.
// */
//
//@RestController
//public class ConsumerController {
//    @Autowired
//    RestTemplate restTemplate;
//
//
//    //使用了Hystrix
//    @Autowired
//    ConsumerService consumerService;
//
//    /**
//     * This just visit <i>/consumer-hello</i>,then this method will user @see {@link RestTemplate}.getForEntity() method,and visit @url http://HELLO-SERVICE/hello
//     * @return the default return of  hello-service/hello
//     */
//    @RequestMapping("/consumer-hello")
//    public String helloConsumer() {
//        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
//    }
//
//    @RequestMapping("/consumer-user")
//    public User consumer1() {
//        return restTemplate.getForEntity("http://HELLO-SERVICE/user", User.class).getBody();
//    }
//
//    // @HystrixCommand(fallbackMethod = "testFallBack")
//    @RequestMapping("/consumer-hello-name")
//    public String consumer2(@RequestParam(name="name",defaultValue = "abc")String name) {
//        return restTemplate.getForEntity("http://HELLO-SERVICE/hello?name={1}", String.class, name).getBody();
//    }
//
//    /**
//     * This method use user defined hystric command to visit the  /HELLO-SERVICE/user method, to get a @see {@link User} module.
//     * url /consumer-command
//     * @param id The id of the @see {@link User} class, default value is 18
//     * @param desc The desc of the @see {@link User} class, default valus is "from hystric:容错保护机制"
//     * @return return a json of the user
//     */
//    @RequestMapping("/consumer-command")
//    public User consumer4(@RequestParam(name="id",defaultValue = "18")Integer id,@RequestParam(name = "desc",defaultValue="from hystric:容错保护机制")String desc) {
//        return new UserCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
//                /* HystrixCommandKey工厂定义依赖名称 */
//                .andCommandKey(HystrixCommandKey.Factory.asKey("HelloWorld")), restTemplate, id,desc).execute();
//    }
//    /**
//     * 容错保护
//     * This method user @see {@link ConsumerService} to visit the http://HELLO-SERVICE/hello?desc={1} method.
//     * @return return
//     */
//    @RequestMapping("/consumer-hystrix-service")
//    public String consumer3() {
//        return consumerService.consumerService();
//    }
//
//}
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//class User {
//    private Integer id;
//    private String name;
//    private Integer age;
//    private String desc;
//}