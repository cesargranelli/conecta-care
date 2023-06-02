package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaTipoContaResponse;

import java.util.List;

public interface TipoContaService {
    List<ConsultaTipoContaResponse> consultar();
}
