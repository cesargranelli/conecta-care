package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaGrupoResponse;
import com.sevenine.conecta.mapper.GrupoMapper;
import com.sevenine.conecta.repository.GrupoRepository;
import com.sevenine.conecta.service.GrupoService;
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
