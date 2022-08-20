package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.ContatoRequest;
import com.sevenine.conecta.controller.data.response.ContatoCadastroResponse;
import com.sevenine.conecta.controller.data.response.ContatoResponse;
import com.sevenine.conecta.repository.ContatoRepository;
import com.sevenine.conecta.repository.data.Contato;
import com.sevenine.conecta.service.ContatoService;
import com.sevenine.conecta.service.converter.ContatoServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContatoServiceImpl implements ContatoService {

    private final ContatoServiceConverter converter;
    private final ContatoRepository repository;

    @Override
    public ContatoCadastroResponse cadastrar(ContatoRequest request) {
        Contato contato = converter.toEntity(request);
        return converter.toResponse(repository.save(contato).getId());
    }

    @Override
    public void alterar(ContatoRequest request) {
        Optional<Contato> contatoOptional = repository.findByIdPlanoSaude(request.getIdPlanoSaude());
        if (contatoOptional.isPresent()) {
            contatoOptional.get().atualizarContato(converter.toEntity(request));
            repository.flush();
        }
    }

    @Override
    public ContatoResponse consultar(Long idPlanoSaude) {
        Optional<Contato> contatoOptional = repository.findByIdPlanoSaude(idPlanoSaude);
        if (contatoOptional.isPresent()) {
            return converter.toResponse(contatoOptional.get());
        } else {
            return ContatoResponse.builder().build();
        }
    }
}
