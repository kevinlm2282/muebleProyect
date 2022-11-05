package com.example.todo.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.todo.dao.MuebleEntity;
import com.example.todo.dao.UserEntity;
import com.example.todo.dao.repository.MuebleRepository;
import com.example.todo.dao.repository.UserRepository;
import com.example.todo.dto.MuebleDto;

import java.util.List;

import javax.transaction.Transactional;
@Service
public class UserBl {
    private Logger LOGGER = LoggerFactory.getLogger(TodoBl.class);
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserBl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserEntity> getUsers() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando consulta para obtener el listado de muebles");
        List<UserEntity> users = this.userRepository.findAll();
        LOGGER.info("BUSINESS-LOGIC: La consulta para obtener el listado de muebles retorno: {}", users);
        return users;
    }

    @Transactional
    public UserEntity saveUser(UserEntity user) {
        LOGGER.info("BUSINESS-LOGIC: Iniciando consulta para registrar un todo's");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity user1 = (UserEntity) userRepository.save(user);
        LOGGER.info("BUSINESS-LOGIC: La consulta para registrar un mueble retorno: {}", user1);
        return user1;
    }

    public void deleteUser(Integer id){
        LOGGER.info("BUSINESS-LOGIC: Iniciando consulta para eliminar un usuario");
        this.userRepository.deleteById(id);
        LOGGER.info("BUSINESS-LOGIC: La consulta para eliminar el usuario");
    }
}
