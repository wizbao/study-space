package com.abot.common.controller;

import com.abot.common.domain.Computer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author weibao
 */
@Tag(name = "ActorController", description = "演员接口")
@RestController
public class ActorController {

    @PostMapping("/one")
    @Operation(summary = "根据id获取演员信息", description = "需要登录后访问")
    public void getActorById(String id, @RequestBody Computer computer) {

    }

    @PostMapping("/test1")
    public String test(HttpServletRequest request){
        String contextPath = request.getContextPath();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        System.out.println("contextPath = " + contextPath);
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "ok";
    }

    @PostMapping("/test2")
    public String test(String name,@RequestParam(required = false) Integer age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "ok";
    }

}
