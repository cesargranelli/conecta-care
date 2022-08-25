package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaInstrucaoResponse;

import java.util.List;

public interface InstrucaoService {
    List<ConsultaInstrucaoResponse> consultar();
}
