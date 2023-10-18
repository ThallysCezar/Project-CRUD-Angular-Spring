package com.project.crudspring.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.project.crudspring.domains.Users;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;

	public String generateToken(Users users) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.create()
					.withIssuer("auth-api")
					.withSubject(users.getLogin())
					.withExpiresAt(genExpirantionDate())
					.sign(algorithm);
		}
		 catch(JWTCreationException exeption) {
			throw new RuntimeException("Error while generating token", exeption);
		}
	}
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("auth-api")
					.build()
					.verify(token)
					.getSubject();
			
		} catch (JWTCreationException exeption) {
			return "";
		}
	}
	
	private Instant genExpirantionDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-02:00"));
	}
}
