package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaGrupoResponse;

import java.util.List;

public interface GrupoService {
    List<ConsultaGrupoResponse> consultar();
}
