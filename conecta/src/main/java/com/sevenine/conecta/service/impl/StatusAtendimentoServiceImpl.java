package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaStatusAtendimentoResponse;
import com.sevenine.conecta.repository.StatusAtendimentoRepository;
import com.sevenine.conecta.mapper.StatusAtendimentoMapper;
import com.sevenine.conecta.service.StatusAtendimentoService;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StatusAtendimentoServiceImpl implements StatusAtendimentoService {

    private final StatusAtendimentoMapper mapper;

    private final StatusAtendimentoRepository repository;

    @Override
    public List<ConsultaStatusAtendimentoResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }
}
