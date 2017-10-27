package com.lc.spring.db.controller;

import com.lc.spring.db.entity.Author;
import com.lc.spring.db.mapper.AuthorMapper;
import com.lc.spring.db.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liangchao03
 *         2017/10/26
 */
@RestController
public class LibraryController {

    @Autowired
    private AuthorMapper authorMapper;

    @RequestMapping("/id")
    public Author getById(@RequestParam Integer id){
        Author author =  authorMapper.getById(id);
        return author;
    }

    @RequestMapping("/name")
    public List<Author> getByName(@RequestParam String name){
        List<Author> authors =  authorMapper.getByName(name);
        return authors;
    }

}

