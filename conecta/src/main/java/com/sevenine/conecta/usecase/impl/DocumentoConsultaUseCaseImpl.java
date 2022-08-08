package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.service.DocumentoConsultaService;
import com.sevenine.conecta.service.data.response.DocumentoResponse;
import com.sevenine.conecta.usecase.DocumentoConsultaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DocumentoConsultaUseCaseImpl implements DocumentoConsultaUseCase {

    private final DocumentoConsultaService service;

    @Override
    public DocumentoResponse executar(Long documentoId) {
        return service.consultar(documentoId);
    }

}
