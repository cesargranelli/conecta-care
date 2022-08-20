package com.sevenine.conecta.converter.tratamento;

import com.sevenine.conecta.controller.data.response.tratamento.ListaTratamentoEmAbertoResponse;
import com.sevenine.conecta.service.data.response.ConsultaListaTratamentoResponse;
import com.sevenine.conecta.service.data.response.PacienteResponse;

import java.util.List;

public interface ConsultaListaTratamentoEmAbertoConverter {
    List<ListaTratamentoEmAbertoResponse> fromServiceResponseToControllerResponse(
            List<ConsultaListaTratamentoResponse> tratamentoList, List<PacienteResponse> pacienteList);
}
