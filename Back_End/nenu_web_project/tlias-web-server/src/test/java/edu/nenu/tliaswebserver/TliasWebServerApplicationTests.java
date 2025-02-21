package edu.nenu.tliaswebserver;

import edu.nenu.tliaswebserver.controller.DeptController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DeptController deptController;

    /**
     * jwt令牌生成测试
     * 注释掉@SpringBootTest 就不会加载springboot环境
     * 相当于普通类单元测试
     */
    @Test
    public void JwtGenerate() {
        // 负载内容
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Tom");

        // 生成令牌
        String jwt1 = Jwts.builder()
                .setClaims(claims)//自定义内容（荷载）Map类型的数据
                .signWith(SignatureAlgorithm.HS256, "nenu")//设置签名算法 签名秘钥
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置过期时间
                .compact();
        System.out.println(jwt1);
    }

    /**
     * jwt令牌解析
     */
    @Test
    public void decodeJwt() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzM5OTgxMzU2LCJ1c2VybmFtZSI6IlRvbSJ9.49bzaKCO1_y7eXKSR11jP0Pkxzt36TY26VaKEY1eD6Y";
        // 解析令牌
        Claims claims = Jwts.parser()
                .setSigningKey("nenu")  //指定签名秘钥
                .parseClaimsJws(jwt)    //传入jwt令牌并解析
                .getBody();             //获得负载部分内容
        System.out.println(claims);
    }
}
