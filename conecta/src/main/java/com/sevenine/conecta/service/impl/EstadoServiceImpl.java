package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaEstadoResponse;
import com.sevenine.conecta.repository.EstadoRepository;
import com.sevenine.conecta.service.EstadoService;
import com.sevenine.conecta.mapper.EstadoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoMapper mapper;

    private final EstadoRepository repository;

    @Override
    public List<ConsultaEstadoResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }

}
