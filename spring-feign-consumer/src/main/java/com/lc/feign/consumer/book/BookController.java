package com.lc.feign.consumer.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liangchao on 17-10-31.
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/feign/bookid")
    public Book feignGetBookById(@RequestParam Integer id){
        Book book = bookService.getBookById(id);
        return book;
    }
}
