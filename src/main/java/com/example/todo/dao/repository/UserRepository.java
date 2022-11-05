package com.example.todo.dao.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.dao.UserEntity;

 public interface UserRepository extends JpaRepository<UserEntity,Integer> {
 Optional<UserEntity> findByUsername(String username);
 }
