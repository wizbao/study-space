package com.abot.dynamicdb;

import com.abot.dynamicdb.service.DBService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DynamicdbApplicationTests {

    @Resource
    private DBService dbService;

    @Test
    void contextLoads() {
        dbService.selectActor();
        dbService.selectCity();
    }

}
