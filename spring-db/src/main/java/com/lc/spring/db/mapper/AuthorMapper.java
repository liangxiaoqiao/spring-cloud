package com.lc.spring.db.mapper;

import com.lc.spring.db.entity.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author liangchao03
 *         2017/10/26
 */
@Mapper
public interface AuthorMapper {

    void insert(Author author);

    void delete(Author author);

    default void delete(Integer id) {
        delete(Author.builder().id(id).build());
    }

    void update(Author author);

    @Select("select * from author where id = #{id}")
    Author getById(@Param("id") Integer id);
}
