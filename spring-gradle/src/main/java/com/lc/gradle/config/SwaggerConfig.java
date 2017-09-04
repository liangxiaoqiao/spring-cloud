package com.lc.gradle.config;

import org.apache.commons.math.fraction.BigFraction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.ZonedDateTime;
import java.util.Optional;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 * @author liangchao03
 * @date 2017/9/4
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    Docket createRestApi() {
return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo()) //创建API的基本信息
        .groupName("LC group")
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.lc.gradle.test")) //扫描的包路径
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiInfo() {
return new ApiInfoBuilder().title("Swagger Title")
        .description("This is description.")
        .termsOfServiceUrl("http://localhost:8088/")
        .contact(new Contact("lc", "http://localhost:8088/", "liangchao03@ppdai.com"))
        .version("1.0")
        .build();
    }

}
