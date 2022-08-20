package com.sevenine.conecta.service;

import com.sevenine.conecta.http.resource.AcompanhanteResponseResource;

import java.util.List;

public interface ConsultaAcompanhanteService {
    AcompanhanteResponseResource find(Long pacienteId, Long acompanhanteId);

    List<AcompanhanteResponseResource> findByListPacienteId(Long pacienteId);
}
