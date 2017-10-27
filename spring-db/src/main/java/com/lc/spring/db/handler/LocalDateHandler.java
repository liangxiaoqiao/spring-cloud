package com.lc.spring.db.handler;

import org.apache.ibatis.type.*;

import java.sql.*;
import java.time.LocalDate;

/**
 * @author liangchao03
 *         2017/10/27
 */
public class LocalDateHandler extends BaseTypeHandler<LocalDate>{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDate parameter, JdbcType jdbcType) throws SQLException {
        ps.setDate(i,Date.valueOf(parameter));
    }

    @Override
    public LocalDate getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if(rs.getDate(columnName) == null){
            return null;
        }
        return rs.getDate(columnName) .toLocalDate();
    }

    @Override
    public LocalDate getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        if(rs.getDate(columnIndex) == null){
            return null;
        }
        return rs.getDate(columnIndex).toLocalDate();
    }

    @Override
    public LocalDate getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if(cs.getDate(columnIndex) == null){
            return null;
        }
        return cs.getDate(columnIndex).toLocalDate();
    }
}
