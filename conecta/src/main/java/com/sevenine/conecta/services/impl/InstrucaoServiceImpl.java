package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaInstrucaoResponse;
import com.sevenine.conecta.repository.InstrucaoRepository;
import com.sevenine.conecta.services.InstrucaoService;
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
