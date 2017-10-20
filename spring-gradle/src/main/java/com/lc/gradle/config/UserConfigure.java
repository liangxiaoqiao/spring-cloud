package com.lc.gradle.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liangchao on 17-10-12.
 */
@Configuration
@EnableConfigurationProperties(value={UserProperties.class,UserAsParamProperties.class})
public class UserConfigure {

    @Bean
    UserAsParamTestBean createParamBean(UserAsParamProperties prop){
        return new UserAsParamTestBean(prop);
    }
}
