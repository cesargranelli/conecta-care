package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.CadastraDocumentoRequest;
import com.sevenine.conecta.controller.data.response.CadastraDocumentoResponse;
import com.sevenine.conecta.controller.data.response.DocumentoConsultaResponse;
import com.sevenine.conecta.exception.DocumentoNaoEncontradoException;
import com.sevenine.conecta.enumerator.Modulo;
import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.enumerator.TipoDocumento;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import com.sevenine.conecta.service.data.response.DocumentoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class DocumentoServiceConverter {

    public SequenceCadastro toEntityCadastro(CadastraDocumentoRequest request) {
        return SequenceCadastro
                .builder()
                .status(StatusCadastro.PENDENTE)
                .documento(request.getNumero())
                .tipo(TipoDocumento.valueOf(request.getTipo()))
                .modulo(Modulo.valueOf(request.getModulo()))
                .build();
    }

    public CadastraDocumentoResponse toResponseCadastro(SequenceCadastro cadastro) {
        return CadastraDocumentoResponse.builder()
                .id(cadastro.getId())
                .status(cadastro.getStatus())
                .build();
    }

    public DocumentoResponse toResponse(SequenceCadastro cadastro) {
        try {
            DocumentoResponse documentoResponse = new DocumentoResponse();
            documentoResponse.setId(cadastro.getId());
            documentoResponse.setDocumento(cadastro.getDocumento());
            documentoResponse.setModulo(cadastro.getModulo());
            documentoResponse.setStatus(cadastro.getStatus());
            documentoResponse.setTipo(cadastro.getTipo());

            return documentoResponse;
        } catch (NullPointerException e) {
            throw new DocumentoNaoEncontradoException(
                    "Documento não localizado na base de dados!", HttpStatus.NOT_FOUND
            );
        }
    }

    public DocumentoConsultaResponse toConsultaResponse(SequenceCadastro cadastro) {
        try {
            return DocumentoConsultaResponse.builder()
                    .cpf(cadastro.getDocumento())
                    .build();
        } catch (NullPointerException e) {
            throw new DocumentoNaoEncontradoException(
                    "Documento não localizado na base de dados!", HttpStatus.NOT_FOUND
            );
        }
    }

}
