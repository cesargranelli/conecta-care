package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.ConsultaAreaAtendimentoResponse;

import java.util.List;

public interface AreaAtendimentoService {
    List<ConsultaAreaAtendimentoResponse> consultar();
}
