package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.exception.DocumentoNaoEncontradoException;
import com.sevenine.conecta.repository.SequenceCadastroRepository;
import com.sevenine.conecta.mapper.DocumentoConsultaServiceMapper;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import com.sevenine.conecta.service.DocumentoConsultaService;
import com.sevenine.conecta.service.data.response.DocumentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DocumentoConsultaServiceImpl implements DocumentoConsultaService {

    private final DocumentoConsultaServiceMapper mapper;

    private final SequenceCadastroRepository repository;

    @Override
    public DocumentoResponse consultar(Long documentoId) {
        Optional<SequenceCadastro> optional = repository.findById(documentoId);
        return mapper.fromEntityData(optional.orElseThrow(() -> new DocumentoNaoEncontradoException(null, HttpStatus.NO_CONTENT)));
    }

}
