package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.response.ConsultaTransporteResponse;
import com.sevenine.conecta.repository.TransporteRepository;
import com.sevenine.conecta.services.TransporteService;
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
