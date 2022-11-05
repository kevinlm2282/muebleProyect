package com.example.todo.api;

import com.example.todo.bl.EntregaBl;
import com.example.todo.bl.MuebleBl;
import com.example.todo.bl.TodoBl;
import com.example.todo.bl.UserBl;
import com.example.todo.dao.EntregaEntity;
import com.example.todo.dao.MuebleEntity;
import com.example.todo.dao.TodoEntity;
import com.example.todo.dao.UserEntity;
import com.example.todo.dto.EntregaDto;
import com.example.todo.dto.MuebleDto;
import com.example.todo.dto.TodoDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/api/entrega")
public class EntregaController {
    private static Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    private EntregaBl entregaBl;
    
    @Autowired
    public EntregaController(EntregaBl entregaBl) {
        this.entregaBl = entregaBl;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EntregaEntity>> getEntregas() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de Entregas");
        List<EntregaEntity> result = entregaBl.getEntregas();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EntregaEntity> saveEntrega(@RequestBody EntregaDto entregaDto) {
        LOGGER.info("REQUEST: Iniciando petición para guardar un mueble");
        EntregaEntity result = entregaBl.saveEntrega(entregaDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}
