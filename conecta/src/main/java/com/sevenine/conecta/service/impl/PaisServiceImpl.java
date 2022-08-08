package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaPaisResponse;
import com.sevenine.conecta.repository.PaisRepository;
import com.sevenine.conecta.service.PaisService;
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
