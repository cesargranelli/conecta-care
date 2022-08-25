package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.request.CadastraDocumentoRequest;
import com.sevenine.conecta.controllers.data.response.CadastraDocumentoResponse;
import com.sevenine.conecta.controllers.data.response.DocumentoConsultaResponse;
import com.sevenine.conecta.enumerator.Modulo;
import com.sevenine.conecta.exception.DocumentoNaoEncontradoException;
import com.sevenine.conecta.repository.SequenceCadastroRepository;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import com.sevenine.conecta.services.DocumentoService;
import com.sevenine.conecta.services.converter.DocumentoServiceConverter;
import com.sevenine.conecta.services.data.response.DocumentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DocumentoServiceImpl implements DocumentoService {

    private final DocumentoServiceConverter converter;
    private final SequenceCadastroRepository repository;

    @Override
    public CadastraDocumentoResponse cadastrar(CadastraDocumentoRequest request) {
        SequenceCadastro cadastro = repository.save(converter.toEntityCadastro(request));
        return converter.toResponseCadastro(cadastro);
    }

    @Override
    public DocumentoResponse pesquisar(CadastraDocumentoRequest request) {
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
