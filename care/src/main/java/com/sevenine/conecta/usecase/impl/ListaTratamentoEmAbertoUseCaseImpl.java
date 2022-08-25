package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.response.tratamento.ListaTratamentoEmAbertoResponse;
import com.sevenine.conecta.converter.tratamento.ConsultaListaTratamentoEmAbertoConverter;
import com.sevenine.conecta.services.ConsultaListaPacienteService;
import com.sevenine.conecta.services.ConsultaListaTratamentoEmAbertoService;
import com.sevenine.conecta.services.data.response.ConsultaListaTratamentoResponse;
import com.sevenine.conecta.services.data.response.PacienteResponse;
import com.sevenine.conecta.usecase.ListaTratamentoEmAbertoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ListaTratamentoEmAbertoUseCaseImpl implements ListaTratamentoEmAbertoUseCase {

    private final ConsultaListaTratamentoEmAbertoConverter converter;

    private final ConsultaListaTratamentoEmAbertoService consultaListaTratamentoEmAbertoService;

    private final ConsultaListaPacienteService consultaListaPacienteService;

    @Override
    public List<ListaTratamentoEmAbertoResponse> executar(Long homeCareId) {
        List<ConsultaListaTratamentoResponse> tratamentoList = consultaListaTratamentoEmAbertoService.consultar(homeCareId);

        List<PacienteResponse> pacienteList = consultaListaPacienteService.consultar(tratamentoList.stream()
                .map(ConsultaListaTratamentoResponse::getPacienteId).distinct().collect(Collectors.toList()));

        return converter.fromServiceResponseToControllerResponse(tratamentoList, pacienteList);
    }

}
