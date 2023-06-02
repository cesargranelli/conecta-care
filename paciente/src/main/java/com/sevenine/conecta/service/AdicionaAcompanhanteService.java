package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.resource.AcompanhanteResource;
import com.sevenine.conecta.adapter.controller.resource.AcompanhanteResponseResource;

public interface AdicionaAcompanhanteService {
    AcompanhanteResponseResource create(AcompanhanteResource acompanhante);
}
