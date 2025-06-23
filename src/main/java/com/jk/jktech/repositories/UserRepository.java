package com.jk.jktech.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jk.jktech.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
