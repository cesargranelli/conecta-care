package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controller.data.response.EnderecoResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.mapper.consulta.ConsultaEnderecoMapper;
import com.sevenine.conecta.repository.EnderecoRepository;
import com.sevenine.conecta.repository.data.Endereco;
import com.sevenine.conecta.service.ConsultaEnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaEnderecoServiceImpl implements ConsultaEnderecoService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final ConsultaEnderecoMapper mapper;

    private final EnderecoRepository repository;

    @Override
    public EnderecoResponse consultar(Long profissionalId) {
        Optional<Endereco> optional = repository.findByProfissionalId(profissionalId);

        return mapper.fromEntityData(optional.orElseThrow(() -> new InformacaoNaoEncontradaException(
                exceptionMessageProperties.getEnderecoNaoEncontrado(),
                HttpStatus.NOT_FOUND
        )));
    }

}
