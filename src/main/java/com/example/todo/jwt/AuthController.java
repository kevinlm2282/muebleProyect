package com.example.todo.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dto.LoginDto;

import javax.validation.Valid;

@RestController
 @RequestMapping("/auth")
 public class AuthController {
 @Autowired
 AuthenticationManager authenticationManager;
 @Autowired
 JwtProvider tokenProvider;
 @PostMapping("/signin")
 public ResponseEntity<JwtResponse> authenticateUser(@Valid
@RequestBody LoginDto login) {
 Authentication authentication = authenticationManager
 .authenticate(new
UsernamePasswordAuthenticationToken(login.getUsername(),
login.getPassword()));

SecurityContextHolder.getContext().setAuthentication(authentication);
 String jwt = tokenProvider.generateToken(authentication);
 return ResponseEntity.ok(new JwtResponse(jwt));
 }
 } 
