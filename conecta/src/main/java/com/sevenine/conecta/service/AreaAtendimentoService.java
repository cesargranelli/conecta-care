package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.response.ConsultaAreaAtendimentoResponse;

import java.util.List;

public interface AreaAtendimentoService {
    List<ConsultaAreaAtendimentoResponse> consultar();
}
