package com.abot.common.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author weibao
 */
@Api( tags = "演员所有接口")
@Controller
public class ActorController {

    @GetMapping("/actor")
    @ApiOperation(value = "根据id获取演员信息",notes = "注意点")
    public void getActorById(@ApiParam(name = "id",value = "演员编号") String id) {

    }



}
