package com.abot.mybatisplusgo.mapper.sqlprovider;


import java.util.List;

/**
 * @author weibao
 */
public class UserProvider {
    public String selectUserByIds(List<Long> ids) {
        StringBuilder sb = new StringBuilder("select * from user where id in (");
        for (Long id : ids) {
            sb.append("#{").append(id).append("},");
        }
        sb.deleteCharAt(sb.length() - 1).append(")");
        return sb.toString();
    }
}
