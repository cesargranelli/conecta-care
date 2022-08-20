package com.sevenine.conecta.converter.atendimento.impl;

import com.sevenine.conecta.controller.data.response.atendimento.AtendimentoResumoResponse;
import com.sevenine.conecta.converter.atendimento.ConsultaAtendimentoResumoConverter;
import com.sevenine.conecta.service.data.response.PacienteResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsultaAtendimentoResumoConverterImpl implements ConsultaAtendimentoResumoConverter {

    @Override
    public List<AtendimentoResumoResponse> fromListAtendimentoPaciente(List<AtendimentoResumoResponse> atendimentos, List<PacienteResponse> pacientes) {
        return atendimentos.stream()
                .map(atendimento -> {
                    AtendimentoResumoResponse atendimentoResumoResponse = new AtendimentoResumoResponse();
                    atendimentoResumoResponse.setId(atendimento.getId());
                    atendimentoResumoResponse.setStatus(atendimento.getStatus());
                    atendimentoResumoResponse.setData(atendimento.getData());
                    atendimentoResumoResponse.setHora(atendimento.getHora());
                    atendimentoResumoResponse.setNomePaciente(pacientes.stream()
                            .filter(pacienteResponse -> pacienteResponse.getId().equals(atendimento.getPacienteId()))
                            .map(pacienteResponse -> pacienteResponse.getNome().concat(" ").concat(pacienteResponse.getSobrenome()))
                            .findAny()
                            .orElse(null)
                    );
                    return atendimentoResumoResponse;
                }).collect(Collectors.toList());
    }

}
