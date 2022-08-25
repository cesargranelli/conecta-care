package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.resource.AcompanhanteResponseResource;

import java.util.List;

public interface ConsultaAcompanhanteService {
    AcompanhanteResponseResource find(Long pacienteId, Long acompanhanteId);

    List<AcompanhanteResponseResource> findByListPacienteId(Long pacienteId);
}
