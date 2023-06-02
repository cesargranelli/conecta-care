package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.tratamento.TratamentoSituacaoRequest;

public interface AdicionaTratamentoSituacaoService {
    void adicionar(TratamentoSituacaoRequest request, Long tratamentoId);
}
