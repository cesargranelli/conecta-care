package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.response.tratamento.ProntuarioResponse;
import com.sevenine.conecta.mapper.tratamento.ConsultaProntuarioMapper;
import com.sevenine.conecta.service.ConsultaListaTratamentoService;
import com.sevenine.conecta.service.ConsultaPacienteService;
import com.sevenine.conecta.service.data.response.PacienteResponse;
import com.sevenine.conecta.service.data.response.TratamentoResponse;
import com.sevenine.conecta.usecase.ConsultaProntuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ConsultaProntuarioUseCaseImpl implements ConsultaProntuarioUseCase {

    private final ConsultaProntuarioMapper mapper;

    private final ConsultaPacienteService consultaPacienteService;
    private final ConsultaListaTratamentoService consultaListaTratamentoService;

    @Override
    public ProntuarioResponse executar(Long pacienteId, Long homeCareId) {
        PacienteResponse pacienteResponse = consultaPacienteService.consultar(pacienteId);

        List<TratamentoResponse> tratamentosResponse = consultaListaTratamentoService.consultar(pacienteId, homeCareId);

        return mapper.fromServiceResponse(pacienteResponse, tratamentosResponse);
    }

}
