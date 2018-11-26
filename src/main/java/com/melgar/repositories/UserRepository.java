package com.melgar.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melgar.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
