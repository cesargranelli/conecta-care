package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.response.ConsultaAreaAtendimentoResponse;
import com.sevenine.conecta.repository.AreaAtendimentoRepository;
import com.sevenine.conecta.services.AreaAtendimentoService;
import com.sevenine.conecta.mapper.AreaAtendimentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AreaAtendimentoServiceImpl implements AreaAtendimentoService {

    private final AreaAtendimentoMapper mapper;

    private final AreaAtendimentoRepository repository;

    @Override
    public List<ConsultaAreaAtendimentoResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }
}
