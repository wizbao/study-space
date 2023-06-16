package com.abot.dynamicdb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试nacos配置是否生效
 * @author weibao
 */
@RestController
@RequestMapping("/config")
@RefreshScope // 热加载，实现配置自动更新
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;
    @Value("${con.name:hello}")
    private String name;
    @Value("${con.port:8081}")
    private int port;

    @GetMapping("/enableCache")
    public boolean getEnableCache() {
        return useLocalCache;
    }
    @GetMapping("/name")
    public String getName() {
        return name;
    }
    @GetMapping("/port")
    public int getPort() {
        return port;
    }
}