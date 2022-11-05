package com.example.todo.jwt;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.todo.dao.UserEntity;
import com.example.todo.dao.repository.UserRepository;

@Service
 @Transactional
 public class UserDetailsServiceImpl implements UserDetailsService
{
 @Autowired
 private UserRepository userRepository;
 @Override
 public UserDetails loadUserByUsername(String username) throws
UsernameNotFoundException {
 UserEntity user = userRepository.findByUsername(username)
 .orElseThrow(() -> new
UsernameNotFoundException("User NOT Found"));
 return UserMapper.userToPrincipal(user);
 }
 }
