package com.sevenine.conecta.service;

import com.sevenine.conecta.controller.data.request.tratamento.AdicionaAcompanhanteRequest;

public interface CadastraAcompanhanteService {
    Long cadastrar(AdicionaAcompanhanteRequest request);
}
