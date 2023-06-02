package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.atendimento.AdicionaAtendimentoRequest;

import java.util.List;

public interface AdicionaAtendimentosService {
    void adicionar(List<AdicionaAtendimentoRequest> requests);
}
