package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaStatusAtendimentoResponse;

import java.util.List;

public interface StatusAtendimentoService {
    List<ConsultaStatusAtendimentoResponse> consultar();
}
