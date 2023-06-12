package com.abot.common.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;

/**
 * @author weibao
 */
@Tag( name = "演员所有接口")
@Controller
public class ActorController {

    @Operation(summary="根据id获取演员信息")
    public void getActorById(String id) {

    }

}
