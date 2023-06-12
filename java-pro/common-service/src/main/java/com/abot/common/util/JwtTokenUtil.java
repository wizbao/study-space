package com.abot.common.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class JwtTokenUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    public JwtTokenUtil() {
    }

    /**
     * 根据指定的信息和加密的key，生成一个加密的Token
     * @param claims
     * @return
     */
    public String generateToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpiredDate())
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .compact();
        return token;
    }

    public void generateHeader(String token) {
        JwsHeader header = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getHeader();
        System.out.println(header);
    }

    /**
     * 根据UserDetails对象，生成一个对应的加密Token
     * @param
     * @return
     */
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.SUBJECT, username);
        claims.put(Claims.ISSUED_AT, new Date());
        return this.generateToken(claims);
    }

    /**
     * 生成Token过期时间
     * @return
     */
    public Date generateExpiredDate() {
        return new Date(System.currentTimeMillis() + this.expiration * 1000L);
    }

    /**
     * 尝试用Token中解析出Jwt的Payload信息
     * @param token
     * @return
     */
    public Claims getClaimsFromToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
            return claims;
        } catch (ExpiredJwtException eje) {
            log.info("Token已经过期:" + token);
            Claims expiredClaims = new DefaultClaims();
            expiredClaims.setExpiration(new Date(System.currentTimeMillis() - 1000L));
            return expiredClaims;
        } catch (Exception e) {
            log.error("非法的Token:" + token);
        }
        return null;
    }

    /**
     * 从Token中获取对应的用户名
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        if (claims == null) {
            return null;
        }
        return claims.getSubject();
    }

    /**
     * 从Token中获取过期时间
     * @param token
     * @return
     */
    public Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        if (claims == null) {
            return null;
        }
        return claims.getExpiration();
    }

    /**
     * 验证Token是否是有效的
     * @param token
     * @return
     */
    public boolean validateToken(String token, String userName) {
        Claims claims = getClaimsFromToken(token);
        if (claims == null) {
            return false;
        }
        String subject = claims.getSubject();
        if (subject.equals(userName) && !isTokenExpired(token)) {
            return true;
        }
        return false;
    }

    /**
     * 检查Token是否过期了
     * @param token
     * @return
     */
    public boolean isTokenExpired(String token) {
        Claims claims = getClaimsFromToken(token);
        if (claims == null) {
            return true;
        }
        Date expiredDate = claims.getExpiration();
        return expiredDate.before(new Date());
    }

    /**
     * 刷新Token的过期时间
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        if (claims == null) {
            return token;
        }
        claims.setIssuedAt(new Date());
        String refreshToken = generateToken(claims);
        return refreshToken;
    }
}