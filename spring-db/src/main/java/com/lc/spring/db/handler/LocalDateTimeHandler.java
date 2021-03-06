package com.lc.spring.db.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author liangchao03
 *         2017/10/27
 */
@MappedTypes(LocalDateTime.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class LocalDateTimeHandler extends BaseTypeHandler<LocalDateTime> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getTimestamp(columnName).toLocalDateTime().plusYears(100);
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getTimestamp(columnIndex).toLocalDateTime().plusYears(100);
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getTimestamp(columnIndex).toLocalDateTime().plusYears(100);
    }
}
