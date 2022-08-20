package com.sevenine.conecta.service;

import com.sevenine.conecta.http.resource.AcompanhanteResource;
import com.sevenine.conecta.http.resource.AcompanhanteResponseResource;

public interface AdicionaAcompanhanteService {
    AcompanhanteResponseResource create(AcompanhanteResource acompanhante);
}
