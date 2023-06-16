package com.abot.mybatisplusgo.mapper;

import com.abot.mybatisplusgo.entity.User;
import com.abot.mybatisplusgo.mapper.sqlprovider.UserProvider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

/**
* @author admin
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-06-15 14:40:41
* @Entity generator.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @SelectProvider(type = UserProvider.class,method = "selectUserByIds")
    List<User> selectUserByIds(@Param("ids") List<Long> ids);
}




