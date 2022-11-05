package com.example.todo.dao;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.example.todo.jwt.Role;

@Table(name = "usuario")
@Entity
 public class UserEntity {

 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name = "user_id")
 private Integer id;
 @Column
 private String nombre;
 @Column
 private Integer telefono;
 @Column
 private String direccion;
 @Column(name = "user")
 @NotNull
 private String username;
 @NotNull
 private String password;
 @Column(name = "estado")
 @NotNull
 private boolean enabled;
 @ManyToMany(fetch=FetchType.LAZY)
 @JoinTable(
 name="usuario_has_rol",
 joinColumns= {@JoinColumn(name="usuario_user_id")},
 inverseJoinColumns = {@JoinColumn(name="rol_rol_id")}
 )
 private List<Role> roles;
 
 public Integer getId() {
 return id;
 }
 public void setId(Integer id) {
 this.id = id;
 }
 public String getUsername() {
 return username;
 }
 public void setUsername(String username) {
 this.username = username;
 }
 public String getPassword() {
 return password;
 }
 public void setPassword(String password) {
 this.password = password;
 }
 public boolean isEnabled() {
 return enabled;
 }
 public void setEnabled(boolean enabled) {
 this.enabled = enabled;
 }
 public List<Role> getRoles() {
 return roles;
 }
 public void setRoles(List<Role> roles) {
 this.roles = roles;
 }
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public Integer getTelefono() {
    return telefono;
}
public void setTelefono(Integer telefono) {
    this.telefono = telefono;
}
public String getDireccion() {
    return direccion;
}
public void setDireccion(String direccion) {
    this.direccion = direccion;
}
 }
