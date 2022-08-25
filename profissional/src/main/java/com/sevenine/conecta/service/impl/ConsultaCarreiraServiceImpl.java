package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controllers.data.response.CarreiraResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.mapper.consulta.ConsultaCarreiraMapper;
import com.sevenine.conecta.repository.CarreiraRepository;
import com.sevenine.conecta.repository.data.Carreira;
import com.sevenine.conecta.services.ConsultaCarreiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaCarreiraServiceImpl implements ConsultaCarreiraService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final ConsultaCarreiraMapper mapper;

    private final CarreiraRepository repository;

    @Override
    public CarreiraResponse consultar(Long profissionalId) {
        Optional<Carreira> optional = repository.findByProfissionalId(profissionalId);

        return mapper.fromEntityData(optional.orElseThrow(() -> new InformacaoNaoEncontradaException(
                exceptionMessageProperties.getCarreiraNaoEncontrado(),
                HttpStatus.NOT_FOUND
        )));
    }

}
