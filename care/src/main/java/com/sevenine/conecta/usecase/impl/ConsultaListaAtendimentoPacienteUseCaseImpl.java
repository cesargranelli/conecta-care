package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.response.atendimento.AtendimentoPacienteResponse;
import com.sevenine.conecta.converter.atendimento.ConsultaListaAtendimentoPacienteUseCaseConverter;
import com.sevenine.conecta.services.ConsultaListaAtendimentoPacienteService;
import com.sevenine.conecta.services.ConsultaListaProfissionalService;
import com.sevenine.conecta.services.data.response.AtendimentoResponse;
import com.sevenine.conecta.services.data.response.AtendimentoProfissionalResponse;
import com.sevenine.conecta.usecase.ConsultaListaAtendimentoPacienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ConsultaListaAtendimentoPacienteUseCaseImpl implements ConsultaListaAtendimentoPacienteUseCase {

    private final ConsultaListaAtendimentoPacienteUseCaseConverter converter;

    private final ConsultaListaAtendimentoPacienteService consultaListaAtendimentoPacienteService;
    private final ConsultaListaProfissionalService consultaListaProfissionalService;

    @Override
    public List<AtendimentoPacienteResponse> executar(Long pacienteId, LocalDate dataConsulta) {
        List<AtendimentoResponse> atendimentoResponseList = consultaListaAtendimentoPacienteService.consultar(pacienteId);

        List<AtendimentoProfissionalResponse> profissionalResponseList =
                consultaListaProfissionalService.consultar(atendimentoResponseList.stream()
                        .map(AtendimentoResponse::getProfissionalId).collect(Collectors.toList()));

        return converter.fromResponseService(atendimentoResponseList, profissionalResponseList);
    }

}
