package com.sevenine.conecta.adapter.controller;

import com.sevenine.conecta.adapter.controller.resource.EnderecoResource;
import com.sevenine.conecta.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "api/v1/endereco")
@RequiredArgsConstructor
public class EnderecoHttp {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResource> create(@RequestBody EnderecoResource resource) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.create(resource));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResource> find(@PathVariable Long id) {
        EnderecoResource response = enderecoService.findById(id);
        if (Objects.isNull(response)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<EnderecoResource> findByIdPaciente(@RequestParam Long idPaciente) {
        EnderecoResource response = enderecoService.findByIdPaciente(idPaciente);
        if (Objects.isNull(response)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<EnderecoResource> edit(@RequestBody EnderecoResource resource) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.edit(resource));
    }

}
