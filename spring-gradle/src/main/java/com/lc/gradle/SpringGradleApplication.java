package com.lc.gradle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liangchao03 on 2017/6/15.
 */
@SpringBootApplication
public class SpringGradleApplication {  //implements EmbeddedServletContainerCustomizer

    public static void main(String[] args) {
        SpringApplication.run(SpringGradleApplication.class, args);
    }

//    @Override
//    public void customize(ConfigurableEmbeddedServletContainer container) {
//        container.setPort(8088);
//    }
}
