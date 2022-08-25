package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.tratamento.AdicionaTratamentoRequest;

public interface AdicionaTratamentoService {
    Long adicionar(AdicionaTratamentoRequest request);
}
