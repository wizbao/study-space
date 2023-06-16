package com.abot.dynamicdb.service.impl;

import com.abot.dynamicdb.entity.Actor;
import com.abot.dynamicdb.entity.City;
import com.abot.dynamicdb.mapper.CityMapper;
import com.abot.dynamicdb.service.CityService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【city】的数据库操作Service实现
* @createDate 2023-06-08 14:18:43
*/
@DS("slave")
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
    implements CityService {

    @Override
    public City getCityById(Integer id){
        City city = this.getById(id);
        return city;
    }
}




