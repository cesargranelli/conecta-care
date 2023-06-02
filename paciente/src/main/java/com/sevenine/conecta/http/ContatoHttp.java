package com.sevenine.conecta.adapter.controller;

import com.sevenine.conecta.adapter.controller.resource.ContatoResource;
import com.sevenine.conecta.adapter.controller.resource.PacienteResource;
import com.sevenine.conecta.services.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/contato")
@RequiredArgsConstructor
public class ContatoHttp {

    private final ContatoService contatoService;

    @PostMapping
    public ContatoResource create(@RequestBody ContatoResource resource) {
        return contatoService.create(resource);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        ContatoResource response = contatoService.find(id);
        if(response == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ContatoResource edit(@RequestBody ContatoResource resource) {
        return contatoService.edit(resource);
    }

}
