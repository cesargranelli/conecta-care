package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.resource.AcompanhanteResource;
import com.sevenine.conecta.controllers.resource.AcompanhanteResponseResource;

public interface AdicionaAcompanhanteService {
    AcompanhanteResponseResource create(AcompanhanteResource acompanhante);
}
