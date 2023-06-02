package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.adapter.controller.data.response.ComplementoResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.mapper.consulta.ConsultaComplementoMapper;
import com.sevenine.conecta.repository.ComplementoRepository;
import com.sevenine.conecta.repository.data.Complemento;
import com.sevenine.conecta.services.ConsultaComplementoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaComplementoServiceImpl implements ConsultaComplementoService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final ConsultaComplementoMapper mapper;

    private final ComplementoRepository repository;

    @Override
    public ComplementoResponse consultar(Long profissionalId) {
        Optional<Complemento> optional = repository.findByProfissionalId(profissionalId);

        return mapper.fromEntityData(optional.orElseThrow(() -> new InformacaoNaoEncontradaException(
                exceptionMessageProperties.getComplementoNaoEncontrado(),
                HttpStatus.NOT_FOUND
        )));
    }

}
