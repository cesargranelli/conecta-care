package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.response.ConsultaParentescoResponse;

import java.util.List;

public interface ParentescoService {
    List<ConsultaParentescoResponse> consultar();
}
