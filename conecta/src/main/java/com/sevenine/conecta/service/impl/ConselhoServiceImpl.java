package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaConselhoResponse;
import com.sevenine.conecta.repository.ConselhoRepository;
import com.sevenine.conecta.service.ConselhoService;
import com.sevenine.conecta.mapper.ConselhoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConselhoServiceImpl implements ConselhoService {

    private final ConselhoMapper mapper;

    private final ConselhoRepository repository;

    @Override
    public List<ConsultaConselhoResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }

}
