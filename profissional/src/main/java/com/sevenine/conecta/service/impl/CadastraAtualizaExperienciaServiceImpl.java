package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.ExperienciaRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaExperienciaResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaExperienciaMapper;
import com.sevenine.conecta.repository.ExperienciaRepository;
import com.sevenine.conecta.service.CadastraAtualizaExperienciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CadastraAtualizaExperienciaServiceImpl implements CadastraAtualizaExperienciaService {

    private final CadastraAtualizaExperienciaMapper mapper;

    private final ExperienciaRepository repository;

    @Override
    public CadastraAtualizaExperienciaResponse salvar(List<ExperienciaRequest> request) {

        repository.deleteByProfissionalId(request.get(0).getProfissionalId());

        repository.saveAll(mapper.toEntityDataList(request));

        return mapper.fromEntityData(request.get(0).getProfissionalId());

    }
}
