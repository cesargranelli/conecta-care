package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaParentescoResponse;

import java.util.List;

public interface ParentescoService {
    List<ConsultaParentescoResponse> consultar();
}
