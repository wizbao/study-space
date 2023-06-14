package com.abot.common;

import com.abot.common.config.JwtConfig;
import com.abot.common.util.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CommonServiceApplicationTests {

    @Resource
    private JwtConfig jwtConfig;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Test
    void contextLoads() {
        String username = "jay";
        String token = jwtTokenUtil.generateToken(username);
        System.out.println("token============>"+token);
        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println("usernameFromToken = " + usernameFromToken);
        jwtTokenUtil.generateHeader(token);
    }

}
