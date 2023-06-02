package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.response.atendimento.AtendimentoResumoResponse;
import com.sevenine.conecta.converter.atendimento.ConsultaAtendimentoResumoConverter;
import com.sevenine.conecta.services.ConsultaListaAtendimentoService;
import com.sevenine.conecta.services.ConsultaListaPacienteService;
import com.sevenine.conecta.services.data.response.PacienteResponse;
import com.sevenine.conecta.usecase.ConsultaListaAtendimentoResumoUseCase;
import com.sevenine.conecta.usecase.rule.CalculaPeriodoMensalRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ConsultaListaAtendimentoResumoUseCaseImpl implements ConsultaListaAtendimentoResumoUseCase {

    private final ConsultaAtendimentoResumoConverter converter;

    private final CalculaPeriodoMensalRule calculaPeriodoMensalRule;

    private final ConsultaListaAtendimentoService consultaListaAtendimentoService;
    private final ConsultaListaPacienteService consultaListaPacienteService;

    @Override
    public List<AtendimentoResumoResponse> executar(Long idHomeCare, LocalDate dataConsulta) {
        Map<String, LocalDate> periodoConsulta = calculaPeriodoMensalRule.executar(dataConsulta);

        List<AtendimentoResumoResponse> atendimentos = consultaListaAtendimentoService.consultar(idHomeCare, periodoConsulta);

        List<Long> pacienteIdList = atendimentos.stream().map(AtendimentoResumoResponse::getPacienteId).collect(Collectors.toList());

        List<PacienteResponse> pacientes = consultaListaPacienteService.consultar(pacienteIdList);

        return converter.fromListAtendimentoPaciente(atendimentos, pacientes);
    }

}
