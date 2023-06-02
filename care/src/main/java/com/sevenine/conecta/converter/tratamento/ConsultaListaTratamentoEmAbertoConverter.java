package com.sevenine.conecta.converter.tratamento;

import com.sevenine.conecta.adapter.controller.data.response.tratamento.ListaTratamentoEmAbertoResponse;
import com.sevenine.conecta.services.data.response.ConsultaListaTratamentoResponse;
import com.sevenine.conecta.services.data.response.PacienteResponse;

import java.util.List;

public interface ConsultaListaTratamentoEmAbertoConverter {
    List<ListaTratamentoEmAbertoResponse> fromServiceResponseToControllerResponse(
            List<ConsultaListaTratamentoResponse> tratamentoList, List<PacienteResponse> pacienteList);
}
