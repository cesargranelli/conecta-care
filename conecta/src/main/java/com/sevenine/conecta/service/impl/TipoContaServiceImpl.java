package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaTipoContaResponse;
import com.sevenine.conecta.repository.TipoContaRepository;
import com.sevenine.conecta.service.TipoContaService;
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
