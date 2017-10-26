package com.lc.spring.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.Map;

/**
 * @author liangchao03
 *         2017/10/26
 */
@Mapper
public interface BookMapper {

    @Select("select * from book where id = #{id}")
    public Map getById(String id);
}
