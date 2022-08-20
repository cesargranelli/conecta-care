package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.controller.data.response.EnderecoCadastroResponse;
import com.sevenine.conecta.controller.data.response.EnderecoResponse;
import com.sevenine.conecta.repository.EnderecoRepository;
import com.sevenine.conecta.repository.data.EnderecoHomecare;
import com.sevenine.conecta.service.EnderecoService;
import com.sevenine.conecta.service.converter.EnderecoServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoServiceConverter converter;
    private final EnderecoRepository repository;

    @Override
    public EnderecoCadastroResponse cadastrar(EnderecoRequest request) {
        EnderecoHomecare enderecoHomecare = converter.toEntity(request);
        return converter.toResponse(repository.save(enderecoHomecare).getId());
    }

    @Override
    public void alterar(EnderecoRequest request) {
        Optional<EnderecoHomecare> enderecoOptional = repository.findByHomecareId(request.getIdHomeCare());
        if (enderecoOptional.isPresent()) {
            enderecoOptional.get().atualizarEndereco(converter.toEntity(request));
            repository.flush();
        } else {
            repository.save(converter.toEntity(request));
        }
    }

    @Override
    public EnderecoResponse consultar(Long idHomeCare) {
        Optional<EnderecoHomecare> enderecoOptional = repository.findByHomecareId(idHomeCare);
        if (enderecoOptional.isPresent()) {
            return converter.toResponse(enderecoOptional.get());
        } else {
            return EnderecoResponse.builder().build();
        }
    }

}
