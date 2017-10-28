package com.lc.spring.db.mapper;

import com.lc.spring.db.entity.Book;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

/**
 * @author liangchao03
 *         2017/10/26
 */
@Mapper
public interface BookMapper {

    @Select("select * from book where id = #{id}")
    @Results(id="bookResult",value = {
            @Result(column = "id",property = "id",id=true),
            @Result(column = "author_id",property = "authorId"),
            @Result(column = "published_in",property = "publishedIn"),
            @Result(column = "language_id",property = "languageId"),
            @Result(column = "language_id",property = "language",one = @One(select = "com.lc.spring.db.mapper.LanguageMapper.getById"))
    })
    Book getById(Integer id);


    @Select("select * from book where author_id = #{authorId}")
    @ResultMap("bookResult")
    List<Book> getByAuthorId(@Param("authorId") Integer authorId);
}
