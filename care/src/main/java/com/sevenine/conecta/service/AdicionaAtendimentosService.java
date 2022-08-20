package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.atendimento.AdicionaAtendimentoRequest;

import java.util.List;

public interface AdicionaAtendimentosService {
    void adicionar(List<AdicionaAtendimentoRequest> requests);
}
