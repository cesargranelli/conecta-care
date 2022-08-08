package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaGrupoResponse;

import java.util.List;

public interface GrupoService {
    List<ConsultaGrupoResponse> consultar();
}
