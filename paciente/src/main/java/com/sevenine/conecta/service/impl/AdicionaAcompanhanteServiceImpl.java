package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.http.resource.AcompanhanteResource;
import com.sevenine.conecta.http.resource.AcompanhanteResponseResource;
import com.sevenine.conecta.mapper.AdicionaAcompanhanteMapper;
import com.sevenine.conecta.repository.AcompanhanteRepository;
import com.sevenine.conecta.repository.entity.AcompanhanteEntity;
import com.sevenine.conecta.service.AdicionaAcompanhanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdicionaAcompanhanteServiceImpl implements AdicionaAcompanhanteService {

    private final AdicionaAcompanhanteMapper mapper;

    private final AcompanhanteRepository repository;

    @Override
    public AcompanhanteResponseResource create(AcompanhanteResource acompanhante) {
        AcompanhanteEntity acompanhanteEntity =
                repository.findByCpfAndPacienteId(acompanhante.getCpf(), acompanhante.getPacienteId())
                        .orElse(mapper.toEntityData(acompanhante));
        try {
            return mapper.fromEntityData(repository.save(acompanhanteEntity));
        } catch (Exception e) {
            return null;
        }
    }

}
