package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.controller.data.response.atendimento.AtendimentoResumoResponse;
import com.sevenine.conecta.converter.atendimento.ConsultaListaAtendimentoConverter;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.repository.AtendimentoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.service.ConsultaListaAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ConsultaListaAtendimentoServiceImpl implements ConsultaListaAtendimentoService {

    private final ExceptionMessageProperties exceptionMessageProperties;

    private final ConsultaListaAtendimentoConverter converter;

    private final AtendimentoRepository repository;

    @Override
    public List<AtendimentoResumoResponse> consultar(Long homeCareId, Map<String, LocalDate> periodoConsulta) {
        Optional<List<Atendimento>> optional =
                repository.findByHomeCareIdAndDataBetween(homeCareId, periodoConsulta.get("dataInicio"), periodoConsulta.get("dataFim"));

        return converter.fromEntityDataList(optional.orElseThrow(() -> new NaoLocalizadoException(
                exceptionMessageProperties.getAtendimentoNaoLocalizado(), HttpStatus.NO_CONTENT
        )));
    }

    @Override
    public List<Atendimento> consultarPorHomeCarePeriodo(Long idHomeCare, Map<String, LocalDate> periodoConsulta) {
        return repository
                .findByHomeCareIdAndDataBetween(idHomeCare, periodoConsulta.get("dataInicio"), periodoConsulta
                .get("dataFim"))
                .orElse(new ArrayList<Atendimento>());
    }

}
