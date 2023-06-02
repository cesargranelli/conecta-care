package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaStatusAtendimentoResponse;

import java.util.List;

public interface StatusAtendimentoService {
    List<ConsultaStatusAtendimentoResponse> consultar();
}
