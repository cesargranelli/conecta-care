package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.converter.atendimento.ConsultaAtendimentoPorProfissionalUseCaseConverter;
import com.sevenine.conecta.services.ConsultaAcompanhanteService;
import com.sevenine.conecta.services.ConsultaListaAtendimentosProfissionalService;
import com.sevenine.conecta.services.ConsultaPacienteService;
import com.sevenine.conecta.services.ConsultaProfissionalService;
import com.sevenine.conecta.services.ConsultaTratamentoService;
import com.sevenine.conecta.services.data.response.AtendimentoResponse;
import com.sevenine.conecta.services.data.response.ProfissionalAtendimentoResponse;
import com.sevenine.conecta.usecase.ConsultaAtendimentoPorProfissionalUseCase;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultaAtendimentoPorProfissionalUseCaseImpl implements ConsultaAtendimentoPorProfissionalUseCase {

    private final ConsultaListaAtendimentosProfissionalService listaAtendimentosService;
    private final ConsultaPacienteService consultaPacienteService;
    private final ConsultaTratamentoService consultaTratamentoService;
    private final ConsultaAcompanhanteService consultaAcompanhanteService;
    private final ConsultaProfissionalService consultaProfissionalService;

    private final ConsultaAtendimentoPorProfissionalUseCaseConverter converter;

    @Override
    public List<ProfissionalAtendimentoResponse> executar(Long profissionalId, LocalDate dataAtendimento) {
        List<AtendimentoResponse> atendimentos = listaAtendimentosService.listar(profissionalId, dataAtendimento);

        return atendimentos.stream()
                .map(atendimento -> converter.toResponse(atendimento,
                        consultaPacienteService.consultar(atendimento.getPacienteId()),
                        consultaAcompanhanteService.consultar(atendimento.getPacienteId(), consultaTratamentoService.consultar(atendimento.getTratamentoId()).getAcompanhante().getId()),
                        consultaProfissionalService.consultar(atendimento.getProfissionalId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProfissionalAtendimentoResponse> executarPorPeriodo(Long profissionalId, LocalDate dataInicio, LocalDate dataFim) {
        List<AtendimentoResponse> atendimentos = listaAtendimentosService.listarPorPeriodo(profissionalId, dataInicio, dataFim);

        return atendimentos.stream()
                .map(atendimento -> converter.toResponse(atendimento,
                        consultaPacienteService.consultar(atendimento.getPacienteId()),
                        consultaAcompanhanteService.consultar(atendimento.getPacienteId(), consultaTratamentoService.consultar(atendimento.getTratamentoId()).getAcompanhante().getId()),
                        consultaProfissionalService.consultar(atendimento.getProfissionalId())))
                .collect(Collectors.toList());
    }
    
}
