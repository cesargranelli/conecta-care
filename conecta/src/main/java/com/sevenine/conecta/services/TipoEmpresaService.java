package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaTipoEmpresaResponse;

import java.util.List;

public interface TipoEmpresaService {
    List<ConsultaTipoEmpresaResponse> consultar();
}
