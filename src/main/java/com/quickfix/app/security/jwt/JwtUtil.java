package com.quickfix.app.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    //  SINGLE SECRET KEY (used for generate + validate)
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    //  Token validity (1 hour)
    private static final long EXPIRATION_TIME = 60 * 60 * 1000;
    private static Object role;

    //  Generate JWT
    public static String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(KEY)
                .compact();
    }

    //  Validate & extract claims
    public static Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //  Expose key for filter (if needed)
    public static Key getKey() {
        return KEY;
    }
}
