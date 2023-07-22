package com.vastracart.login.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {


    @Value("$(app.sercret)")
    private String secret;

    public String generateToken(String subject) {
        return Jwts.builder().setId("ndsk").setSubject("jbsdjk").setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secret.getBytes())).compact();

    }

    public Claims getClaim(String token) {

        return Jwts.parser().setSigningKey(Base64.getEncoder().encode(secret.getBytes())).parseClaimsJws(token)
                .getBody();
    }

    public Date getExpDate(String token) {
        return getClaim(token).getExpiration();
    }

    public String getUserName(String token) {
        return getClaim(token).getSubject();
    }

    public boolean isTokenExpire(String token) {
        Date expDate = getExpDate(token);
        return expDate.before(new Date(System.currentTimeMillis()));
    }

    public boolean validateToken(String token, String userName) {
        String tokenuserName = getUserName(token);

        return (userName.equalsIgnoreCase(tokenuserName) && !isTokenExpire(token));
    }
}
