package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaParentescoResponse;
import com.sevenine.conecta.mapper.ParentescoMapper;
import com.sevenine.conecta.repository.ParentescoRepository;
import com.sevenine.conecta.services.ParentescoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ParentescoServiceImpl implements ParentescoService {

    private final ParentescoMapper mapper;

    private final ParentescoRepository repository;

    @Override
    public List<ConsultaParentescoResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }

}
