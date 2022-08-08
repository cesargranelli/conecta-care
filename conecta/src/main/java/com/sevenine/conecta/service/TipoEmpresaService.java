package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaTipoEmpresaResponse;

import java.util.List;

public interface TipoEmpresaService {
    List<ConsultaTipoEmpresaResponse> consultar();
}
