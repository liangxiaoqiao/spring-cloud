package com.lc.spring.db.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author liangchao03
 *         2017/10/27
 */

public class LocalDateTimeVarcharHandler extends BaseTypeHandler<LocalDateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType) throws SQLException {
        if(parameter == null){
            ps.setString(i,null);
        }
        ps.setString(i,String.valueOf(parameter.toEpochSecond(ZoneOffset.UTC)));
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        if(result == null || "".equals(result.trim())){
            return null;
        }
        return LocalDateTime.ofEpochSecond(Long.parseLong(result),0, ZoneOffset.UTC);
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        if(result == null || "".equals(result.trim())){
            return null;
        }
        return LocalDateTime.ofEpochSecond(Long.parseLong(result),0, ZoneOffset.UTC);
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        if(result == null || "".equals(result.trim())){
            return null;
        }
        return LocalDateTime.ofEpochSecond(Long.parseLong(result),0, ZoneOffset.UTC);
    }
}
