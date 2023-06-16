package com.abot.mybatisplusgo.service;

import com.abot.mybatisplusgo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author admin
* @description 针对表【user】的数据库操作Service
* @createDate 2023-06-15 14:40:41
*/
public interface UserService extends IService<User> {
    Boolean insertUser(User user);
}
