package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaTipoEmpresaResponse;

import java.util.List;

public interface TipoEmpresaService {
    List<ConsultaTipoEmpresaResponse> consultar();
}
