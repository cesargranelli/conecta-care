package com.sevenine.conecta.controllers;

import com.sevenine.conecta.controllers.resource.HistoricoMedicoResource;
import com.sevenine.conecta.services.HistoricoMedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/historico-medico")
@RequiredArgsConstructor
public class HistoricoMedicoHttp {

    private final HistoricoMedicoService historicoMedicoService;

    @PostMapping
    public HistoricoMedicoResource create(@RequestBody HistoricoMedicoResource resource) {
        return historicoMedicoService.create(resource);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        HistoricoMedicoResource response = historicoMedicoService.find(id);
        if(response == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public HistoricoMedicoResource edit(@RequestBody HistoricoMedicoResource resource) {
        return historicoMedicoService.edit(resource);
    }

}
