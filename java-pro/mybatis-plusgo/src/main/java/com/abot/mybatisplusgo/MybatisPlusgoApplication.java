package com.abot.mybatisplusgo;

import com.abot.mybatisplusgo.entity.User;
import com.abot.mybatisplusgo.mapper.UserMapper;
import com.abot.mybatisplusgo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MybatisPlusgoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusgoApplication.class, args);
    }

    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = userMapper.selectUserByIds(Arrays.asList(1L, 2L));
        System.out.println(users);
    }
}
