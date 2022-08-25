package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controllers.data.response.ExperienciaResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.mapper.consulta.ConsultaExperienciaMapper;
import com.sevenine.conecta.repository.ExperienciaRepository;
import com.sevenine.conecta.repository.data.Experiencia;
import com.sevenine.conecta.services.ConsultaExperienciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaExperienciaServiceImpl implements ConsultaExperienciaService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final ConsultaExperienciaMapper mapper;

    private final ExperienciaRepository repository;

    @Override
    public List<ExperienciaResponse> consultar(Long profissionalId) {

        Optional<List<Experiencia>> optional = repository.findByProfissionalId(profissionalId);

        return mapper.fromEntityDataList(optional.orElseThrow(() -> new InformacaoNaoEncontradaException(
                exceptionMessageProperties.getExperienciaNaoEncontrado(),
                HttpStatus.NOT_FOUND
        )));
    }

}
