package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controller.data.response.ContaResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.mapper.consulta.ConsultaContaMapper;
import com.sevenine.conecta.repository.ContaRepository;
import com.sevenine.conecta.repository.data.Conta;
import com.sevenine.conecta.service.ConsultaContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaContaServiceImpl implements ConsultaContaService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final ConsultaContaMapper mapper;

    private final ContaRepository repository;

    @Override
    public ContaResponse consultar(Long profissionalId) {
        Optional<Conta> optional = repository.findByProfissionalId(profissionalId);

        return mapper.fromEntityData(optional.orElseThrow(() -> new InformacaoNaoEncontradaException(
                exceptionMessageProperties.getContaNaoEncontrado(),
                HttpStatus.NOT_FOUND
        )));
    }
}
