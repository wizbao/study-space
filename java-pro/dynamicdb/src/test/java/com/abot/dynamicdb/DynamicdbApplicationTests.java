package com.abot.dynamicdb;

import com.abot.dynamicdb.entity.Actor;
import com.abot.dynamicdb.service.DBService;
import com.abot.dynamicdb.service.impl.ActorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DynamicdbApplicationTests {

    @Resource
    private DBService dbService;
    @Resource
    private ActorServiceImpl actorService;

    @Test
    void contextLoads() {
        dbService.selectActor();
        dbService.selectCity();
    }

    @Test
    void test2() {
        Actor actor = new Actor();
        actor.setActorId(2);
        actor.setFirstName("aaa");
        actor.setLastName("");
        int row = actorService.updateActor(actor);
        System.out.println(row == 1 ? "更新成功" : "更新失败");
    }

}
