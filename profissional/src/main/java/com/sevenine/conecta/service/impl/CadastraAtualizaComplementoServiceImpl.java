package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.request.ComplementoRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaComplementoResponse;
import com.sevenine.conecta.converter.cadastro.CadastraAtualizaComplementoConverter;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaComplementoMapper;
import com.sevenine.conecta.repository.ComplementoRepository;
import com.sevenine.conecta.repository.data.Complemento;
import com.sevenine.conecta.services.CadastraAtualizaComplementoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CadastraAtualizaComplementoServiceImpl implements CadastraAtualizaComplementoService {

    private final CadastraAtualizaComplementoMapper mapper;

    private final CadastraAtualizaComplementoConverter converter;

    private final ComplementoRepository repository;

    @Override
    public CadastraAtualizaComplementoResponse salvar(ComplementoRequest request) {
        Optional<Complemento> optional = repository.findByProfissionalId(request.getProprietarioId());

        if (optional.isPresent()) {
            request.setId(optional.get().getId());
            repository.flush();
        }

        Complemento complemento = converter.toEntityData(request);

        return mapper.fromEntityData(repository.saveAndFlush(complemento));

    }
}
