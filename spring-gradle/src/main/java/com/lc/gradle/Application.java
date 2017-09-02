package com.lc.gradle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liangchao03 on 2017/6/15.
 */
@SpringBootApplication
public class Application {  //implements EmbeddedServletContainerCustomizer

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void customize(ConfigurableEmbeddedServletContainer container) {
//        container.setPort(8088);
//    }
}
