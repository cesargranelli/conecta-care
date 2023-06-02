package com.sevenine.conecta.adapter.controller;

import com.sevenine.conecta.adapter.controller.resource.AcompanhanteResource;
import com.sevenine.conecta.adapter.controller.resource.AcompanhanteResponseResource;
import com.sevenine.conecta.services.AdicionaAcompanhanteService;
import com.sevenine.conecta.services.ConsultaAcompanhanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(path = "api/v1/paciente/acompanhantes")
@RequiredArgsConstructor
public class AcompanhanteHttp {

    private final AdicionaAcompanhanteService adicionaAcompanhanteService;
    private final ConsultaAcompanhanteService consultaAcompanhanteService;

    @PostMapping
    public ResponseEntity<AcompanhanteResponseResource> create(@RequestBody AcompanhanteResource acompanhante) {
        AcompanhanteResponseResource response = adicionaAcompanhanteService.create(acompanhante);

        if (isNull(response)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AcompanhanteResponseResource>> acompanhantes(@RequestHeader Long pacienteId) {
        List<AcompanhanteResponseResource> responseList = consultaAcompanhanteService.findByListPacienteId(pacienteId);

        if (responseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("{acompanhanteId}")
    public ResponseEntity<AcompanhanteResponseResource> acompanhante(@RequestHeader Long pacienteId, @PathVariable Long acompanhanteId) {
        AcompanhanteResponseResource response = consultaAcompanhanteService.find(pacienteId, acompanhanteId);

        if (isNull(response)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }

}
