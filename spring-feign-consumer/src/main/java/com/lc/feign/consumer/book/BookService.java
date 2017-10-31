package com.lc.feign.consumer.book;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liangchao on 17-10-31.
 */
@FeignClient("db-one-service")
public interface BookService {
    @RequestMapping("/book/id")
    Book getBookById(@RequestParam(value = "id") Integer id);
}
