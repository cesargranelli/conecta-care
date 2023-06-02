package com.sevenine.conecta.adapter.controller;

import com.sevenine.conecta.adapter.controller.resource.PacienteNomeDocumentoResource;
import com.sevenine.conecta.adapter.controller.resource.PacientePesquisaResource;
import com.sevenine.conecta.adapter.controller.resource.PacienteResource;
import com.sevenine.conecta.adapter.controller.resource.PacienteResponseResource;
import com.sevenine.conecta.services.ConsultaAcompanhanteService;
import com.sevenine.conecta.services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(path = "api/v1/paciente")
@RequiredArgsConstructor
public class PacienteHttp {

    private final PacienteService pacienteService;
    private final ConsultaAcompanhanteService consultaAcompanhanteService;

    @PostMapping
    public ResponseEntity<PacienteResponseResource> create(@RequestBody PacienteResource paciente) {
        PacienteResource pacienteCadastrado = pacienteService.create(paciente);
        PacienteResponseResource pacienteResponseResource = new PacienteResponseResource(pacienteCadastrado.getId());
        return ResponseEntity.ok(pacienteResponseResource);
    }

    @GetMapping(params = "documento")
    public ResponseEntity<PacienteResource> getByCpf(@RequestParam(name = "documento") String cpf) {
        PacienteResource pacienteResource = this.pacienteService.findByCpf(cpf);

        if (isNull(pacienteResource)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pacienteResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResource> find(@PathVariable Long id) {
        PacienteResource response = pacienteService.find(id);

        if (response == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public PacienteResource edit(@RequestBody PacienteResource paciente) {
        return pacienteService.edit(paciente);
    }

    @GetMapping(params = "nome")
    public ResponseEntity<List<PacienteNomeDocumentoResource>> getByName(@RequestParam(name = "nome") String nome) {
        List<PacienteNomeDocumentoResource> pacientesNomeDocumento = this.pacienteService.findByNome(nome);

        if (isNull(pacientesNomeDocumento)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pacientesNomeDocumento);
    }

    @GetMapping("lista")
    public ResponseEntity<List<PacienteResource>> listaPacientesPorIds(@RequestHeader("pacientes") List<Long> idsPacientes) {
        List<PacienteResource> responseList = pacienteService.findByListId(idsPacientes);

        if (responseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("cpf")
    public ResponseEntity<PacienteResource> findByCpf(@RequestHeader("cpf") String cpf) {
        return ResponseEntity.ok().body(pacienteService.findByCpf(cpf));
    }

    @GetMapping("listaCpf")
    public ResponseEntity<List<PacientePesquisaResource>> getCpfListByName(@RequestHeader("nome") String nome) {
        return ResponseEntity.ok().body(pacienteService.getCpfListByName(nome));
    }

}
