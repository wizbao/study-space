package com.abot.dynamicdb.service;

import com.abot.dynamicdb.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【city】的数据库操作Service
* @createDate 2023-06-08 14:18:43
*/
public interface CityService extends IService<City> {

    City getCityById(Integer id);
}
