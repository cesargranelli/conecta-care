package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.adapter.controller.data.response.EnderecoCadastroResponse;
import com.sevenine.conecta.adapter.controller.data.response.EnderecoResponse;
import com.sevenine.conecta.exception.DadosNaoEncontradosException;
import com.sevenine.conecta.repository.EnderecoRepository;
import com.sevenine.conecta.repository.data.Endereco;
import com.sevenine.conecta.services.EnderecoService;
import com.sevenine.conecta.services.converter.EnderecoServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoServiceConverter converter;
    private final EnderecoRepository repository;

    @Override
    public EnderecoCadastroResponse cadastrar(EnderecoRequest request) {
        Endereco endereco = converter.toEntity(request);
        return converter.toResponse(repository.save(endereco).getId());
    }

    @Override
    public void alterar(EnderecoRequest request) {
        try {
            Endereco endereco = repository.findByIdPlanoSaude(request.getIdPlanoSaude());
            endereco.atualizarEndereco(converter.toEntity(request));
            repository.flush();
        } catch (NullPointerException e) {
            throw new DadosNaoEncontradosException(
                    "Endereço do Plano de Saúde não encontrado", HttpStatus.NOT_FOUND
            );
        }
    }

    @Override
    public EnderecoResponse consultar(Long idPlanoSaude) {
        try {
            return converter.toResponse(repository.findByIdPlanoSaude(idPlanoSaude));
        } catch (NullPointerException e) {
            throw new DadosNaoEncontradosException(
                    "Endereço do Plano de Saúde não encontrado", HttpStatus.NOT_FOUND
            );
        }
    }

}
