package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.response.ConsultaCategoriaCnhResponse;
import com.sevenine.conecta.repository.CategoriaCnhRepository;
import com.sevenine.conecta.services.CategoriaCnhService;
import com.sevenine.conecta.mapper.CategoriaCnhMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaCnhServiceImpl implements CategoriaCnhService {

    private final CategoriaCnhMapper mapper;

    private final CategoriaCnhRepository repository;

    @Override
    public List<ConsultaCategoriaCnhResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }
}
