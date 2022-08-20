package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.tratamento.TratamentoSituacaoRequest;

public interface AdicionaTratamentoSituacaoService {
    void adicionar(TratamentoSituacaoRequest request, Long tratamentoId);
}
