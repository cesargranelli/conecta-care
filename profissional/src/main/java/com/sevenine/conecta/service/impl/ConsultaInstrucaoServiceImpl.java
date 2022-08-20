package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.repository.InstrucaoRepository;
import com.sevenine.conecta.repository.data.Instrucao;
import com.sevenine.conecta.service.ConsultaInstrucaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsultaInstrucaoServiceImpl implements ConsultaInstrucaoService {

    private final InstrucaoRepository repository;

    @Override
    public Instrucao consultar(Long instrucaoId) {

        return repository.findById(instrucaoId).orElseThrow(() -> new InformacaoNaoEncontradaException(null, HttpStatus.NO_CONTENT));

    }
}
