package com.sevenine.conecta.converter.tratamento.impl;

import com.sevenine.conecta.controllers.data.response.tratamento.ListaTratamentoEmAbertoResponse;
import com.sevenine.conecta.converter.tratamento.ConsultaListaTratamentoEmAbertoConverter;
import com.sevenine.conecta.services.data.response.ConsultaListaTratamentoResponse;
import com.sevenine.conecta.services.data.response.PacienteResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ConsultaListaTratamentoEmAbertoConverterImpl implements ConsultaListaTratamentoEmAbertoConverter {

    @Override
    public List<ListaTratamentoEmAbertoResponse> fromServiceResponseToControllerResponse(
            List<ConsultaListaTratamentoResponse> tratamentoList, List<PacienteResponse> pacienteList) {

        return tratamentoList.stream().map(tratamento -> {
            ListaTratamentoEmAbertoResponse listaTratamentoEmAbertoResponse = new ListaTratamentoEmAbertoResponse();
            listaTratamentoEmAbertoResponse.setId(tratamento.getId());
            listaTratamentoEmAbertoResponse.setDescricao(tratamento.getDescricao());
            listaTratamentoEmAbertoResponse.setPacienteId(getPacienteId(tratamento.getPacienteId(), pacienteList));
            listaTratamentoEmAbertoResponse.setNomePaciente(getNomePaciente(tratamento.getPacienteId(), pacienteList));

            return listaTratamentoEmAbertoResponse;
        }).collect(Collectors.toList());
    }

    private Long getPacienteId(Long pacienteId, List<PacienteResponse> pacienteList) {
        PacienteResponse pacienteResponse = pacienteList.stream().filter(paciente -> paciente.getId().equals(pacienteId))
                .findFirst().orElse(null);

        if (isNull(pacienteResponse)) return null;
        return pacienteResponse.getId();
    }

    private String getNomePaciente(Long pacienteId, List<PacienteResponse> pacienteList) {
        PacienteResponse pacienteResponse = pacienteList.stream().filter(paciente -> paciente.getId().equals(pacienteId))
                .findFirst().orElse(null);

        if (isNull(pacienteResponse)) return "";
        return pacienteResponse.getNome().concat(" ").concat(pacienteResponse.getSobrenome());
    }


}
