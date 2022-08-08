package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.DocumentoRequest;
import com.sevenine.conecta.controller.data.response.DocumentoCadastraResponse;
import com.sevenine.conecta.controller.data.response.DocumentoConsultaResponse;
import com.sevenine.conecta.exception.DocumentoNaoEncontradoException;
import com.sevenine.conecta.repository.SequenceCadastroRepository;
import com.sevenine.conecta.service.converter.DocumentoServiceConverter;
import com.sevenine.conecta.enumerator.Modulo;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import com.sevenine.conecta.service.DocumentoService;
import com.sevenine.conecta.service.data.response.DocumentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentoServiceImpl implements DocumentoService {

    private final DocumentoServiceConverter converter;
    private final SequenceCadastroRepository repository;

    @Override
    public DocumentoCadastraResponse cadastrar(DocumentoRequest request) {
        SequenceCadastro cadastro = repository.save(converter.toEntityCadastro(request));
        return converter.toResponseCadastro(cadastro);
    }

    @Override
    public DocumentoResponse pesquisar(DocumentoRequest request) {
        SequenceCadastro cadastro =
                repository.findByDocumentoAndModulo(request.getNumero(), Modulo.valueOf(request.getModulo()));
        return converter.toResponse(cadastro);
    }

    @Override
    public DocumentoConsultaResponse buscar(Long documentoId) {
        Optional<SequenceCadastro> optional = repository.findById(documentoId);
        return converter.toConsultaResponse(optional.orElseThrow(() -> new DocumentoNaoEncontradoException(
                "Documento não cadastrado!", HttpStatus.NOT_FOUND
        )));
    }

}
