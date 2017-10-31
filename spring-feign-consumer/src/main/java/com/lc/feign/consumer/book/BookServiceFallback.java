package com.lc.feign.consumer.book;

import org.springframework.stereotype.Component;

/**
 * Created by liangchao on 17-10-31.
 */
@Component
public class BookServiceFallback  implements  BookService{
    @Override
    public Book getBookById(Integer id) {
        Book book = new Book();
        book.setTitle("BookService Fallback.");
        return book;
    }
}
