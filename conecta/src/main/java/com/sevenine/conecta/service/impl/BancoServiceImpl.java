package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaBancoResponse;
import com.sevenine.conecta.repository.BancoRepository;
import com.sevenine.conecta.service.BancoService;
import com.sevenine.conecta.mapper.BancoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BancoServiceImpl implements BancoService {

    private final BancoMapper mapper;

    private final BancoRepository repository;

    @Override
    public List<ConsultaBancoResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }
}
