package com.abot.dynamicdb.service.impl;

import com.abot.dynamicdb.entity.Actor;
import com.abot.dynamicdb.mapper.ActorMapper;
import com.abot.dynamicdb.service.ActorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【actor】的数据库操作Service实现
* @createDate 2023-06-08 14:08:45
*/
@Service
public class ActorServiceImpl extends ServiceImpl<ActorMapper, Actor>
    implements ActorService {
    public Actor getActorById(Integer id){
        Actor actor = this.getById(id);
        return actor;
    }
}




