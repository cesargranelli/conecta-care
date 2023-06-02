package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaPaisResponse;
import com.sevenine.conecta.repository.PaisRepository;
import com.sevenine.conecta.services.PaisService;
import com.sevenine.conecta.mapper.PaisMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaisServiceImpl implements PaisService {

    private final PaisMapper mapper;

    private final PaisRepository repository;

    @Override
    public List<ConsultaPaisResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }
}
