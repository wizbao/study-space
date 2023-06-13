package com.abot.dynamicdb.service;

import com.abot.dynamicdb.entity.Actor;
import com.abot.dynamicdb.entity.City;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 动态数据源服务
 * @author weibao
 */
@Service
public class DBService {

    @Resource
    private ActorService actorService;
    @Resource
    private CityService cityService;

    public void selectActor(){
        Actor ac = actorService.getActorById(1);
        System.out.println("Actor信息："+ac);
    }
    public void selectCity(){
        City city = cityService.getCityById(1);
        System.out.println("City信息："+city);
    }
}
