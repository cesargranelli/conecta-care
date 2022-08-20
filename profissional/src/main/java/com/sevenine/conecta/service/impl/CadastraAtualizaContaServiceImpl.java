package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.ContaRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaContaResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaContaMapper;
import com.sevenine.conecta.repository.ContaRepository;
import com.sevenine.conecta.repository.data.Conta;
import com.sevenine.conecta.service.CadastraAtualizaContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CadastraAtualizaContaServiceImpl implements CadastraAtualizaContaService {

    private final CadastraAtualizaContaMapper mapper;

    private final ContaRepository repository;

    @Override
    public CadastraAtualizaContaResponse salvar(ContaRequest request) {
        Optional<Conta> optional = repository.findByProfissionalId(request.getProprietarioId());

        if (optional.isPresent()) {
            request.setId(optional.get().getId());
            repository.flush();
        }

        Conta conta = mapper.toEntityData(request);

        return mapper.fromEntityData(repository.saveAndFlush(conta));
    }

}
