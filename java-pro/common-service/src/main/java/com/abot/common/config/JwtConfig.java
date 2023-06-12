package com.abot.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    /**
     * 加密的密钥
     */
    private String secret;

    /**
     * 过期时间（秒）
     */
    private long expiration;

    /**
     * 请求头
     */
    private String tokenHeader;

    /**
     * 前缀
     */
    private String tokenBearer;
}
