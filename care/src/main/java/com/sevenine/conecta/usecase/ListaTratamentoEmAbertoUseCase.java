package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.tratamento.ListaTratamentoEmAbertoResponse;

import java.util.List;

public interface ListaTratamentoEmAbertoUseCase {
    List<ListaTratamentoEmAbertoResponse> executar(Long homeCareId);
}
