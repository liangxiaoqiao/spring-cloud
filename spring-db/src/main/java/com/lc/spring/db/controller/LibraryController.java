package com.lc.spring.db.controller;

import com.lc.spring.db.entity.Author;
import com.lc.spring.db.entity.Book;
import com.lc.spring.db.entity.Language;
import com.lc.spring.db.mapper.AuthorMapper;
import com.lc.spring.db.mapper.BookMapper;
import com.lc.spring.db.mapper.LanguageMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liangchao03
 *         2017/10/26
 */
@RestController
public class LibraryController {

    private final Logger logger = Logger.getLogger(getClass());


    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private LanguageMapper languageMapper;

    @RequestMapping("/author/id")
    public Author getById(@RequestParam Integer id) {
        Author author = authorMapper.getById(id);
        System.out.println(author);
        return author;
    }

    @RequestMapping("/author/name")
    public List<Author> getByName(@RequestParam String name) {
        List<Author> authors = authorMapper.getByName(name);
        return authors;
    }

    @RequestMapping("/author/insert")
    public String insertAuthor() {
        Author author = Author.builder().firstName("first").lastName("last").dateOfBirth(LocalDate.of(2016, 12, 12)).yearOfBirth(2016).insertTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build();
        authorMapper.insert(author);
        return "success";
    }

    @RequestMapping("/author/update")
    public String updateAuthor(@RequestBody Author author){
        authorMapper.update(author);
        return "success";
    }



    @RequestMapping("/book/id")
    public Book getBookById(@RequestParam Integer id) {
        Book book = bookMapper.getById(id);
        return book;
    }

    @RequestMapping("/language/id")
    public Language getLanguageById(@RequestParam Integer id) {
        Language language = languageMapper.getById(id);
        return language;
    }

    @RequestMapping("/language/id2")
    public Language getLanguageById2(@RequestParam Integer id) {
        Language language = languageMapper.getById2(id);
        return language;
    }



    /**
     *
     */
    @Autowired
    private DiscoveryClient client;

    @Autowired
    private Registration registration;

    @RequestMapping("/discovery")
    public String discover(){
        logger.info(client);
        List<ServiceInstance > instances = client.getInstances(registration.getServiceId());
        logger.info(instances);
        return "disvocer";
    }

}

