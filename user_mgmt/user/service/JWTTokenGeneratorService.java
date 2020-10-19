package com.estore.user_mgmt.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenGeneratorService {
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	@Value("${jwt.secret}")
	private String secret;

	public String createToken(Map<String, Object> claims, String userId) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userId)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	public String generateToken(String userId) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userId);
	}
}
