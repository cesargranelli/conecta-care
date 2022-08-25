package com.sevenine.conecta.converter.atendimento.impl;

import com.sevenine.conecta.controllers.data.response.atendimento.AtendimentoResumoResponse;
import com.sevenine.conecta.converter.atendimento.ConsultaListaAtendimentoConverter;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.repository.data.AtendimentoSituacao;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ConsultaListaAtendimentoConverterImpl implements ConsultaListaAtendimentoConverter {

    @Override
    public List<AtendimentoResumoResponse> fromEntityDataList(List<Atendimento> atendimentos) {
        return atendimentos.stream().map(atendimento -> {
            AtendimentoResumoResponse atendimentoResumoResponse = new AtendimentoResumoResponse();
            atendimentoResumoResponse.setId(atendimento.getId());
            atendimentoResumoResponse.setPacienteId(atendimento.getPacienteId());
            atendimentoResumoResponse.setData(atendimento.getData());
            atendimentoResumoResponse.setHora(atendimento.getHora());
            atendimentoResumoResponse.setStatus(statusRecente(atendimento.getSituacoes()));
            return atendimentoResumoResponse;
        }).collect(Collectors.toList());
    }

    private String statusRecente(List<AtendimentoSituacao> situacoes) {
        if (isNull(situacoes) || situacoes.isEmpty()) return null;
        return situacoes.stream().max(Comparator.comparing(AtendimentoSituacao::getDataHora))
                .orElse(new AtendimentoSituacao()).getStatus().getDescricao();
    }

}
