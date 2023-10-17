package com.project.crudspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.crudspring.domains.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

	UserDetails findByLogin(String login);
}
