package com.abot.transactiongo.service.impl;

import com.abot.transactiongo.entity.Actor;
import com.abot.transactiongo.mapper.ActorMapper;
import com.abot.transactiongo.service.ActorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

/**
* @author admin
* @description 针对表【actor】的数据库操作Service实现
* @createDate 2023-06-08 16:32:40
*/
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@Service
public class ActorServiceImpl extends ServiceImpl<ActorMapper, Actor>
    implements ActorService {

    @Resource
    private ActorMapper actorMapper;

    @Override
    public boolean updateActorById(Actor actor) {
        return this.updateById(actor);
    }

    @Override
    public boolean addActor(Actor actor){
        int insert = actorMapper.insert(actor);
        return insert > 0;
    }

//    @Resource
//    private ActorServiceImpl proxy;

    @Transactional(rollbackFor = Exception.class)
    public void testTransactional() throws FileNotFoundException {
        Actor actor1 = new Actor();
        actor1.setActorId(2);
        actor1.setFirstName("java");
        actor1.setLastName("world");
        updateActorById(actor1);

        Actor actor2 = new Actor();
        actor2.setFirstName("aaa");
        actor2.setLastName("bbb");
        actor2.setLastUpdate(new Date());
//        int i = 1/0;
        new FileInputStream("");
        addActor(actor2);
        System.out.println("方法成功执行");
    }

    public void foo() throws FileNotFoundException {
        ActorServiceImpl proxy = (ActorServiceImpl) AopContext.currentProxy();
        proxy.testTransactional();

//        testTransactional();
    }
}




