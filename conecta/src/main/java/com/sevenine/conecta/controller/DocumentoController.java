package com.sevenine.conecta.controller;

import com.sevenine.conecta.controller.data.request.DocumentoRequest;
import com.sevenine.conecta.controller.data.response.DocumentoCadastraResponse;
import com.sevenine.conecta.service.data.response.DocumentoResponse;
import com.sevenine.conecta.usecase.DocumentoConsultaUseCase;
import com.sevenine.conecta.usecase.DocumentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoUseCase documentoUseCase;
    private final DocumentoConsultaUseCase documentoConsultaUseCase;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid DocumentoRequest request) {
        DocumentoCadastraResponse response = documentoUseCase.cadastrar(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "{documentoId}")
    public ResponseEntity<?> consulta(@PathVariable Long documentoId) {
        DocumentoResponse response = documentoConsultaUseCase.executar(documentoId);
        return ResponseEntity.ok().body(response);
    }

}

