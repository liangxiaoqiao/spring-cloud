package com.lc.spring.db.mapper;

import com.lc.spring.db.entity.Author;
import com.lc.spring.db.handler.LocalDateHandler;
import com.lc.spring.db.handler.LocalDateTimeVarcharHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author liangchao03
 *         2017/10/26
 */
@Mapper
public interface AuthorMapper {

    void insert(Author author);

    void delete(Author author);

    default void delete(Integer id) {
    }

    void update(Author author);

    @Select("select * from author where id = #{id}")
    @Results(id="authorResult",value = {
            @Result(id=true,column = "id",property = "id",javaType = Integer.class ),
            @Result(column="first_name",property = "firstName"),
            @Result(column="last_name",property = "lastName"),
            @Result(column="date_of_birth",property = "dateOfBirth",typeHandler = LocalDateHandler.class),
            @Result(column="year_of_birth",property = "yearOfBirth"),
            @Result(column="inserttime",property = "insertTime"),
            @Result(column="updatetimestr",property = "updateTime",typeHandler = LocalDateTimeVarcharHandler.class)
    })
    Author getById(@Param("id") Integer id);


    @Select("select * from author where name like '%#{name}%'")
    List<Author> getByName(String name);

}
