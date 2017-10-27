package com.lc.spring.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liangchao03
 *         2017/10/26
 */
@SpringBootApplication
public class SpringDBApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDBApplication.class, args);
    }
}
