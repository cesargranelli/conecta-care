package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraAtualizaEnderecoResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaEnderecoMapper;
import com.sevenine.conecta.repository.EnderecoRepository;
import com.sevenine.conecta.repository.data.Endereco;
import com.sevenine.conecta.services.CadastraAtualizaEnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CadastraAtualizaEnderecoServiceImpl implements CadastraAtualizaEnderecoService {

    private final CadastraAtualizaEnderecoMapper mapper;

    private final EnderecoRepository repository;

    @Override
    public CadastraAtualizaEnderecoResponse salvar(EnderecoRequest request) {
        Optional<Endereco> optional = repository.findByProfissionalId(request.getProprietarioId());

        if (optional.isPresent()) {
            request.setId(optional.get().getId());
            repository.flush();
        }

        Endereco endereco = mapper.toEntityData(request);

        return mapper.fromEntityData(repository.saveAndFlush(endereco));
    }

}
