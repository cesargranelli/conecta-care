package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.tratamento.AdicionaAcompanhanteRequest;

public interface CadastraAcompanhanteService {
    Long cadastrar(AdicionaAcompanhanteRequest request);
}
