package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.response.ConsultaEstadoCivilResponse;
import com.sevenine.conecta.repository.EstadoCivilRepository;
import com.sevenine.conecta.services.EstadoCivilService;
import com.sevenine.conecta.mapper.EstadoCivilMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {

    private final EstadoCivilMapper mapper;

    private final EstadoCivilRepository repository;

    @Override
    public List<ConsultaEstadoCivilResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }

}
