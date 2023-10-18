package com.project.crudspring.infra.security;

import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;
import com.project.crudspring.domains.Users;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;

	public String generateToken(Users users) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
		}
		 catch() {
			
		}
	}
}
