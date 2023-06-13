package com.abot.transactiongo.service;

import com.abot.transactiongo.entity.Actor;
import com.abot.transactiongo.mapper.ActorMapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author admin
* @description 针对表【actor】的数据库操作Service
* @createDate 2023-06-08 16:32:40
*/
public interface ActorService extends IService<Actor> {

     boolean updateActorById(Actor actor);
     boolean addActor(Actor actor);
}
