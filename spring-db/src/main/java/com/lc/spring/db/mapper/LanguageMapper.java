package com.lc.spring.db.mapper;

import com.lc.spring.db.entity.Language;
import org.apache.ibatis.annotations.*;

/**
 * Created by liangchao on 17-10-28.
 */
@Mapper
public interface LanguageMapper {

    @Select("select * from language where id = #{id}")
    @Results(id = "languageId",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name")
    })
    Language getById(@Param("id") Integer id);


    @Select("select * from language where id = #{id}")
    @ResultType(Language.class)
    Language getById2(@Param("id") Integer id);
}
