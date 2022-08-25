package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.response.ConsultaTipoEmpresaResponse;
import com.sevenine.conecta.repository.TipoEmpresaRepository;
import com.sevenine.conecta.services.TipoEmpresaService;
import com.sevenine.conecta.mapper.TipoEmpresaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TipoEmpresaServiceImpl implements TipoEmpresaService {

    private final TipoEmpresaMapper mapper;

    private final TipoEmpresaRepository repository;

    @Override
    public List<ConsultaTipoEmpresaResponse> consultar() {
        return mapper.fromEntityData(repository.findAll());
    }

}
