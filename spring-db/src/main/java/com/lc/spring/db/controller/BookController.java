package com.lc.spring.db.controller;

import com.lc.spring.db.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangchao03
 *         2017/10/26
 */
@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/id")
    public Object getById(@RequestParam String id){
        return bookMapper.getById(id);
    }


}

