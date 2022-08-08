package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.request.DocumentoRequest;
import com.sevenine.conecta.controller.data.response.DocumentoCadastraResponse;
import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.exception.DocumentoDuplicadoException;
import com.sevenine.conecta.exception.DocumentoNaoEncontradoException;
import com.sevenine.conecta.service.DocumentoService;
import com.sevenine.conecta.service.data.response.DocumentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DocumentoUseCase {

    private final DocumentoService documentoService;

    public DocumentoCadastraResponse cadastrar(DocumentoRequest request) {
        try {
            DocumentoResponse response = documentoService.pesquisar(request);
            if (!response.getStatus().equals(StatusCadastro.PENDENTE)) {
                throw new DocumentoDuplicadoException("Documento já cadastrado na base de dados", HttpStatus.PRECONDITION_FAILED);
            }
            return DocumentoCadastraResponse.builder()
                    .id(response.getId())
                    .status(response.getStatus())
                    .build();
        } catch (DocumentoNaoEncontradoException e) {
            return documentoService.cadastrar(request);
        }
    }

}
