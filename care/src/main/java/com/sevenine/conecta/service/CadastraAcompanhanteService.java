package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.tratamento.AdicionaAcompanhanteRequest;

public interface CadastraAcompanhanteService {
    Long cadastrar(AdicionaAcompanhanteRequest request);
}
