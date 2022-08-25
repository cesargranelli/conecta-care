package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.request.ProfissionalRequest;
import com.sevenine.conecta.controllers.data.response.CadastraAtualizaProfissionalResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaProfissionalMapper;
import com.sevenine.conecta.repository.ProfissionalRepository;
import com.sevenine.conecta.repository.data.Profissional;
import com.sevenine.conecta.services.CadastraAtualizaProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CadastraAtualizaProfissionalServiceImpl implements CadastraAtualizaProfissionalService {

    private final CadastraAtualizaProfissionalMapper mapper;

    private final ProfissionalRepository repository;

    @Override
    public CadastraAtualizaProfissionalResponse salvar(ProfissionalRequest request) {
        Profissional profissional = repository.saveAndFlush(mapper.toEntityData(request));

        return mapper.fromEntityData(profissional);
    }

}
