package com.lc.spring.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liangchao03
 *         2017/10/26
 */
@MapperScan(basePackages= "com.lc.spring.db.mapper")
@SpringBootApplication
public class SpringDBApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDBApplication.class, args);
    }
}
