package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controller.data.response.EscolaridadeResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.mapper.consulta.ConsultaEscolaridadeMapper;
import com.sevenine.conecta.repository.EscolaridadeRepository;
import com.sevenine.conecta.repository.data.Escolaridade;
import com.sevenine.conecta.service.ConsultaEscolaridadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaEscolaridadeServiceImpl implements ConsultaEscolaridadeService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final ConsultaEscolaridadeMapper mapper;

    private final EscolaridadeRepository repository;

    @Override
    public EscolaridadeResponse consultar(Long profissionalId) {
        Optional<Escolaridade> optional = repository.findByProfissionalId(profissionalId);

        return mapper.fromEntityData(optional.orElseThrow(() -> new InformacaoNaoEncontradaException(
                exceptionMessageProperties.getEscolaridadeNaoEncontrado(),
                HttpStatus.NOT_FOUND
        )));
    }

    private void rolesStringToRolesList(String instituicaoEnsino) {
        List<String> rolesList = java.util.Arrays.asList(org.springframework.util.StringUtils.commaDelimitedListToStringArray(instituicaoEnsino.replaceAll("[\\[\\]\"]", "")));

    }

}
