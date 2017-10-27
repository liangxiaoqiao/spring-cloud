package com.lc.spring.db.config;

import com.lc.spring.db.convert.MyHttpMessageConvert;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author liangchao03
 *         2017/10/27
 */
@Configuration
public class DBConfiguration  extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(myHttpMessageConvert());
        super.configureMessageConverters(converters);
    }

    @Bean
    MyHttpMessageConvert myHttpMessageConvert(){
        return new MyHttpMessageConvert();
    }
}

