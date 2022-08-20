package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.http.resource.AcompanhanteResponseResource;
import com.sevenine.conecta.mapper.ConsultaAcompanhanteMapper;
import com.sevenine.conecta.repository.AcompanhanteRepository;
import com.sevenine.conecta.repository.entity.AcompanhanteEntity;
import com.sevenine.conecta.service.ConsultaAcompanhanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaAcompanhanteServiceImpl implements ConsultaAcompanhanteService {

    private final ConsultaAcompanhanteMapper mapper;

    private final AcompanhanteRepository repository;

    @Override
    public AcompanhanteResponseResource find(Long pacienteId, Long acompanhanteId) {
        Optional<AcompanhanteEntity> optional = repository.findByPacienteIdAndId(pacienteId, acompanhanteId);
        return mapper.fromEntityData(optional.orElse(null));
    }

    @Override
    public List<AcompanhanteResponseResource> findByListPacienteId(Long pacienteId) {
        Optional<List<AcompanhanteEntity>> optionalList = repository.findByPacienteId(pacienteId);
        return mapper.fromEntityDataList(optionalList.orElse(new ArrayList<>()));
    }

}
