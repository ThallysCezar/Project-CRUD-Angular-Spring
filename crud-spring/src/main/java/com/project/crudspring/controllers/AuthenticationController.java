package com.project.crudspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.crudspring.domains.Users;
import com.project.crudspring.dtos.AuthenticationDTO;
import com.project.crudspring.dtos.RegisterDTO;
import com.project.crudspring.repositories.UsersRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsersRepository repository;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		final var userNamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
		final var auth = this.authenticationManager.authenticate(userNamePassword);
		
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if(this.repository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
		
		Users newUser = new Users(data.getLogin(), encryptedPassword, data.getRole());
		
		this.repository.save(newUser);
		
		return ResponseEntity.ok().build();
	}
}
