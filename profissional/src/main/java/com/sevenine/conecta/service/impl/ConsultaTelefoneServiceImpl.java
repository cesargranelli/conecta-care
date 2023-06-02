package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.adapter.controller.data.response.TelefoneResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.mapper.consulta.ConsultaTelefoneMapper;
import com.sevenine.conecta.repository.TelefoneRepository;
import com.sevenine.conecta.repository.data.Telefone;
import com.sevenine.conecta.services.ConsultaTelefoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaTelefoneServiceImpl implements ConsultaTelefoneService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final ConsultaTelefoneMapper mapper;

    private final TelefoneRepository repository;

    @Override
    public TelefoneResponse consultar(Long profissionalId) {
        Optional<Telefone> optional = repository.findByProfissionalId(profissionalId);

        return mapper.fromEntityData(optional.orElseThrow(() -> new InformacaoNaoEncontradaException(
                exceptionMessageProperties.getTelefoneNaoEncontrado(),
                HttpStatus.NOT_FOUND
        )));
    }
}
