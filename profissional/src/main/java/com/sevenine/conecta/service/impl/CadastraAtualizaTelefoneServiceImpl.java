package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.request.TelefoneRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaTelefoneResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaTelefoneMapper;
import com.sevenine.conecta.repository.TelefoneRepository;
import com.sevenine.conecta.repository.data.Telefone;
import com.sevenine.conecta.services.CadastraAtualizaTelefoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CadastraAtualizaTelefoneServiceImpl implements CadastraAtualizaTelefoneService {

    private final CadastraAtualizaTelefoneMapper mapper;

    private final TelefoneRepository repository;

    @Override
    public CadastraAtualizaTelefoneResponse salvar(TelefoneRequest request) {
        Optional<Telefone> optional = repository.findByProfissionalId(request.getProprietarioId());

        if (!optional.isPresent()) {
            return mapper.fromEntityData(repository.saveAndFlush(mapper.toEntityData(request)));
        } else {
            Telefone telefone = optional.get();
            mapper.updateTelefone(request, telefone);
            repository.flush();
            return mapper.fromEntityData(telefone);
        }
    }

}
