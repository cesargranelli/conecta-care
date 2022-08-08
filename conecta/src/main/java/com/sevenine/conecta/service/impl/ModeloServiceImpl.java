package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaModeloResponse;
import com.sevenine.conecta.mapper.ModeloMapper;
import com.sevenine.conecta.repository.ModeloRepository;
import com.sevenine.conecta.service.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModeloServiceImpl implements ModeloService {

    private final ModeloMapper mapper;

    private final ModeloRepository repository;

    @Override
    public List<ConsultaModeloResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }
}
