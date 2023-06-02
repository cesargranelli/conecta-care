package com.sevenine.conecta.adapter.controller;

import com.sevenine.conecta.adapter.controller.data.request.CadastraDocumentoRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraDocumentoResponse;
import com.sevenine.conecta.services.data.response.DocumentoResponse;
import com.sevenine.conecta.usecase.DocumentoConsultaUseCase;
import com.sevenine.conecta.usecase.DocumentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping(path = "documentos")
@RestController
public class DocumentoController {

    private final DocumentoUseCase documentoUseCase;
    private final DocumentoConsultaUseCase documentoConsultaUseCase;

    @PostMapping
    public ResponseEntity<CadastraDocumentoResponse> cadastra(@RequestBody @Valid CadastraDocumentoRequest request) {
        CadastraDocumentoResponse response = documentoUseCase.cadastrar(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "{documentoId}")
    public ResponseEntity<?> consulta(@PathVariable Long documentoId) {
        DocumentoResponse response = documentoConsultaUseCase.executar(documentoId);
        return ResponseEntity.ok().body(response);
    }

}

