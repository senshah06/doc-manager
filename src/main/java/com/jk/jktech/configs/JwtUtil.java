package com.jk.jktech.configs;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;

@Component
public class JwtUtil {

	private static final String SECRET_KEY = "";

	@Value("${jwt.secret}")
	 private String secretKey;
	
	 @Value("${jwt.expiration}")
	 private long expiration;
	 
	private SecretKey getSigningKey() {
	    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
	    return Keys.hmacShaKeyFor(keyBytes);
	}

	public String generateToken(String username) {

	    return Jwts.builder()
	            .setSubject(username)
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
	            .signWith(getSigningKey(), SignatureAlgorithm.HS512)
	            .compact();
	}

	public Claims getClaimsFromToken(String token) {
	    return Jwts.parserBuilder()
	            .setSigningKey(getSigningKey())
	            .build()
	            .parseClaimsJws(token)
	            .getBody();
	}


    public boolean validateToken(String token, String username) {
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject().equals(username) && !claims.getExpiration().before(new Date());
    }
}
