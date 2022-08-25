package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaStatusAtendimentoResponse;

import java.util.List;

public interface StatusAtendimentoService {
    List<ConsultaStatusAtendimentoResponse> consultar();
}
