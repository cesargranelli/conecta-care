package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaTipoContaResponse;

import java.util.List;

public interface TipoContaService {
    List<ConsultaTipoContaResponse> consultar();
}
