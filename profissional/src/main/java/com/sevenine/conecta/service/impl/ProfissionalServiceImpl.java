package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.mapper.ProfissionalMapper;
import com.sevenine.conecta.repository.ProfissionalRepository;
import com.sevenine.conecta.repository.data.Profissional;
import com.sevenine.conecta.services.ProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.sevenine.conecta.config.Constants.PROFISSIONAL_NAO_LOCALIZADO;

@RequiredArgsConstructor
@Component
public class ProfissionalServiceImpl implements ProfissionalService {

    private final ProfissionalMapper mapper;

    private final ProfissionalRepository repository;

    @Override
    public ProfissionalResponse consultar(Long idProfissional) {
        Optional<Profissional> optionalProfissional = repository.findById(idProfissional);
        return mapper.fromEntityData(optionalProfissional.orElseThrow(() ->
                new InformacaoNaoEncontradaException(PROFISSIONAL_NAO_LOCALIZADO, HttpStatus.NOT_FOUND)));
    }

}
