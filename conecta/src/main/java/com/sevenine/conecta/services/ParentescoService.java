package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaParentescoResponse;

import java.util.List;

public interface ParentescoService {
    List<ConsultaParentescoResponse> consultar();
}
