package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.atendimento.GrupoBaixaRequest;

import java.util.List;

public interface AdicionaCamposBaixaAtendimentoService {
    void adicionar(List<GrupoBaixaRequest> grupos, List<String> fotos, Long atendimentoId);
}
