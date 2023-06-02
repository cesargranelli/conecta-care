package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaTipoContaResponse;
import com.sevenine.conecta.repository.TipoContaRepository;
import com.sevenine.conecta.services.TipoContaService;
import com.sevenine.conecta.mapper.TipoContaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TipoContaServiceImpl implements TipoContaService {

    private final TipoContaMapper mapper;

    private final TipoContaRepository repository;

    @Override
    public List<ConsultaTipoContaResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }
}
