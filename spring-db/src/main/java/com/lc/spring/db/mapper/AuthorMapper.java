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
public interface    AuthorMapper {

    @Insert("insert into author(first_name,last_name,date_of_birth,year_of_birth,inserttime,updatetimestr) values (#{firstName},#{lastName},#{dateOfBirth},#{yearOfBirth},#{insertTime},#{updateTime})")
    void insert(Author author);

    @Delete("delete from author where id = #{id}")
    void delete(Author author);

    @Update("update author set first_name=#{firstName},last_name=#{lastName},date_of_birth=#{dateOfBirth},year_of_birth=#{yearOfBirth},inserttime=#{insertTime},updatetimestr=#{updateTime} where id=#{id}")
    void update(Author author);

    @Select("select * from author where id = #{id}")
    @Results(id="authorResult",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column="first_name",property = "firstName"),
            @Result(column="last_name",property = "lastName"),
            @Result(column="date_of_birth",property = "dateOfBirth",typeHandler = LocalDateHandler.class),
            @Result(column="year_of_birth",property = "yearOfBirth"),
            @Result(column="inserttime",property = "insertTime"),
            @Result(column="updatetimestr",property = "updateTime",typeHandler = LocalDateTimeVarcharHandler.class),
            @Result(column="id",property = "book",many = @Many(select = "com.lc.spring.db.mapper.BookMapper.getByAuthorId"))
    })
    Author getById(@Param("id") Integer id);


    @Select("select * from author where first_name like \"%\"#{name}\"%\" ")
    List<Author> getByName(@Param("name") String name);

}
