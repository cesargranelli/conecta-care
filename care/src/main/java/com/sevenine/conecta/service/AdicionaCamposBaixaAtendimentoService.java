package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.atendimento.GrupoBaixaRequest;

import java.util.List;

public interface AdicionaCamposBaixaAtendimentoService {
    void adicionar(List<GrupoBaixaRequest> grupos, List<String> fotos, Long atendimentoId);
}
