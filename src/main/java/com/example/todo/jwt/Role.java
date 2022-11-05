package com.example.todo.jwt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
 @Table(name = "rol")
 public class Role {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name = "rol_id")
 private int id;
 @Enumerated(EnumType.STRING)
 @Column(name = "rol_name")
 private RoleName name;
 public int getId() {
 return id;
 }
 public void setId(int id) {
 this.id = id;
 }
 public RoleName getName() {
 return name;
 }
 public void setName(RoleName name) {
 this.name = name;
 }
 }
