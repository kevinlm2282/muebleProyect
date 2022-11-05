package com.example.todo.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.dao.EntregaEntity;
import com.example.todo.dao.MuebleEntity;
import com.example.todo.dao.repository.EntregaRepository;
import com.example.todo.dao.repository.MuebleRepository;
import com.example.todo.dto.EntregaDto;
import com.example.todo.dto.MuebleDto;

import java.util.List;

import javax.transaction.Transactional;

/**
 * EntregaBl
 */
@Service
public class EntregaBl {
    
    private Logger LOGGER = LoggerFactory.getLogger(TodoBl.class);
    private EntregaRepository entregaRepository;
    @Autowired
    public EntregaBl(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }
    
    public List<EntregaEntity> getEntregas() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando consulta para obtener el listado de entregas");
        List<EntregaEntity> entragaList = this.entregaRepository.findAll();
        LOGGER.info("BUSINESS-LOGIC: La consulta para obtener el listado de muebles retorno: {}", entragaList);
        return entragaList;
    }

    @Transactional
    public EntregaEntity saveEntrega(EntregaDto entregaDto) {
        LOGGER.info("BUSINESS-LOGIC: Iniciando consulta para registrar una entrega");
        EntregaEntity entregaEntity = new EntregaEntity(entregaDto.getFecha(), entregaDto.getTotal(), entregaDto.getPropietario(),
        entregaDto.getFecha_entrega(),entregaDto.getUsuario_user_id(), entregaDto.getMuebles());
        EntregaEntity entrega = this.entregaRepository.saveAndFlush(entregaEntity);
        LOGGER.info("BUSINESS-LOGIC: La consulta para registrar una entrega retorno: {}", entrega);
        return entrega;
    }
}