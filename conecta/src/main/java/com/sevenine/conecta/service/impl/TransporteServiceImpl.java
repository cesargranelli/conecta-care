package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ConsultaTransporteResponse;
import com.sevenine.conecta.repository.TransporteRepository;
import com.sevenine.conecta.service.TransporteService;
import com.sevenine.conecta.mapper.TransporteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransporteServiceImpl implements TransporteService{

    private final TransporteMapper mapper;

    private final TransporteRepository repository;

    @Override
    public List<ConsultaTransporteResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }
}
