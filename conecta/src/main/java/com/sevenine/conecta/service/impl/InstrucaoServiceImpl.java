package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaInstrucaoResponse;
import com.sevenine.conecta.repository.InstrucaoRepository;
import com.sevenine.conecta.service.InstrucaoService;
import com.sevenine.conecta.mapper.InstrucaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InstrucaoServiceImpl implements InstrucaoService {

    private final InstrucaoMapper mapper;

    private final InstrucaoRepository repository;

    @Override
    public List<ConsultaInstrucaoResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }

}
