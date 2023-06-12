package com.abot.dynamicdb.service;

import com.abot.dynamicdb.entity.Actor;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【actor】的数据库操作Service
* @createDate 2023-06-08 14:08:45
*/
public interface ActorService extends IService<Actor> {

    Actor getActorById(Integer id);
}
