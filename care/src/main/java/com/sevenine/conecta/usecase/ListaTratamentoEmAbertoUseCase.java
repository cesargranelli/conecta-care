package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.tratamento.ListaTratamentoEmAbertoResponse;

import java.util.List;

public interface ListaTratamentoEmAbertoUseCase {
    List<ListaTratamentoEmAbertoResponse> executar(Long homeCareId);
}
