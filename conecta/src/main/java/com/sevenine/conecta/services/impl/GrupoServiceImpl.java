package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaGrupoResponse;
import com.sevenine.conecta.mapper.GrupoMapper;
import com.sevenine.conecta.repository.GrupoRepository;
import com.sevenine.conecta.services.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoMapper mapper;

    private final GrupoRepository repository;

    @Override
    public List<ConsultaGrupoResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }
}
