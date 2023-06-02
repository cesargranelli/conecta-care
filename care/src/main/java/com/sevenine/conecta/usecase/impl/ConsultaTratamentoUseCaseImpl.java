package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.response.tratamento.ConsultaTratamentoResponse;
import com.sevenine.conecta.converter.tratamento.ConsultaTratamentoConverter;
import com.sevenine.conecta.services.ConsultaAcompanhanteService;
import com.sevenine.conecta.services.ConsultaPacienteService;
import com.sevenine.conecta.services.ConsultaProfissionalService;
import com.sevenine.conecta.services.ConsultaTratamentoService;
import com.sevenine.conecta.services.data.response.TratamentoResponse;
import com.sevenine.conecta.usecase.ConsultaTratamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ConsultaTratamentoUseCaseImpl implements ConsultaTratamentoUseCase {

    private final ConsultaTratamentoConverter converter;

    private final ConsultaTratamentoService consultaTratamentoService;
    private final ConsultaPacienteService consultaPacienteService;
    private final ConsultaAcompanhanteService consultaAcompanhanteService;
    private final ConsultaProfissionalService consultaProfissionalService;

    @Override
    public ConsultaTratamentoResponse executar(Long tratamentoId) {
        TratamentoResponse tratamentoResponse = consultaTratamentoService.consultar(tratamentoId);

        tratamentoResponse.setPaciente(consultaPacienteService.consultar(tratamentoResponse.getPaciente().getId()));
        tratamentoResponse.setAcompanhante(consultaAcompanhanteService.consultar(tratamentoResponse.getPaciente().getId(), tratamentoResponse.getAcompanhante().getId()));
        tratamentoResponse.setProfissional(consultaProfissionalService.consultar(tratamentoResponse.getProfissional().getId()));
        tratamentoResponse.setAtendimentos(tratamentoResponse.getAtendimentos().stream()
                .peek(atendimento -> atendimento.setProfissional(consultaProfissionalService.consultar(atendimento.getProfissional().getId()))).collect(Collectors.toList()));

        return converter.fromTratamentoResponseToConsultaTratamentoResponse(tratamentoResponse);
    }

}
