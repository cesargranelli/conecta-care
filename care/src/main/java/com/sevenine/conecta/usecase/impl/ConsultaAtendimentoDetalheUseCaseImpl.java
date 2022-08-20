package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.response.atendimento.ConsultaAtendimentoDetalheResponse;
import com.sevenine.conecta.mapper.atendimento.ConsultaAtendimentoDetalheMapper;
import com.sevenine.conecta.service.*;
import com.sevenine.conecta.service.data.response.*;
import com.sevenine.conecta.usecase.ConsultaAtendimentoDetalheUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConsultaAtendimentoDetalheUseCaseImpl implements ConsultaAtendimentoDetalheUseCase {

    private final ConsultaAtendimentoDetalheMapper mapper;

    private final ConsultaAtendimentoService atendimentoService;
    private final ConsultaTratamentoService tratamentoService;
    private final ConsultaPlantonistaService plantonistaService;
    private final ConsultaAcompanhanteService acompanhanteService;
    private final ConsultaProfissionalService profissionalService;

    @Override
    public ConsultaAtendimentoDetalheResponse executar(Long idAtendimento) {
        com.sevenine.conecta.service.data.response.AtendimentoDetalheResponse atendimento = atendimentoService.consultar(idAtendimento);

        TratamentoResponse tratamento = tratamentoService.consultar(atendimento.getTratamento().getId());

        PlantonistaResponse plantonista =
                plantonistaService.consultar(tratamento.getHomeCare().getId(), atendimento.getPlantonista().getId());

        AcompanhanteResponse acompanhante =
                acompanhanteService.consultar(tratamento.getPaciente().getId(), tratamento.getAcompanhante().getId());

        AtendimentoProfissionalResponse profissional = profissionalService.consultar(atendimento.getProfissional().getId());

        return mapper.fromAtendimentoAndProfissional(atendimento, plantonista, acompanhante, profissional);
    }

}
