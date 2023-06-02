package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.request.CadastraDocumentoRequest;
import com.sevenine.conecta.adapter.controller.data.response.CadastraDocumentoResponse;
import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.exception.DocumentoDuplicadoException;
import com.sevenine.conecta.exception.DocumentoNaoEncontradoException;
import com.sevenine.conecta.services.DocumentoService;
import com.sevenine.conecta.services.data.response.DocumentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DocumentoUseCase {

    private final DocumentoService documentoService;

    public CadastraDocumentoResponse cadastrar(CadastraDocumentoRequest request) {
        try {
            DocumentoResponse response = documentoService.pesquisar(request);
            if (!response.getStatus().equals(StatusCadastro.PENDENTE)) {
                throw new DocumentoDuplicadoException("Documento já cadastrado na base de dados", HttpStatus.PRECONDITION_FAILED);
            }
            return CadastraDocumentoResponse.builder()
                    .id(response.getId())
                    .status(response.getStatus())
                    .build();
        } catch (DocumentoNaoEncontradoException e) {
            return documentoService.cadastrar(request);
        }
    }

}
