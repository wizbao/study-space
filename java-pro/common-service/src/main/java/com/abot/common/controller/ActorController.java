package com.abot.common.controller;

import com.abot.common.domain.Computer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
