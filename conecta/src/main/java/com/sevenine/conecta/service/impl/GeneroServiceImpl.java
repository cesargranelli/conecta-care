package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaGeneroResponse;
import com.sevenine.conecta.mapper.GeneroMapper;
import com.sevenine.conecta.repository.GeneroRepository;
import com.sevenine.conecta.service.GeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GeneroServiceImpl implements GeneroService {

    private final GeneroMapper mapper;

    private final GeneroRepository repository;

    @Override
    public List<ConsultaGeneroResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }

}
