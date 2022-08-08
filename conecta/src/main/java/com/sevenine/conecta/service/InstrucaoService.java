package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaInstrucaoResponse;

import java.util.List;

public interface InstrucaoService {
    List<ConsultaInstrucaoResponse> consultar();
}
