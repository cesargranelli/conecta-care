package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.repository.ConselhoRepository;
import com.sevenine.conecta.repository.data.Conselho;
import com.sevenine.conecta.service.ConsultaConselhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsultaConselhoServiceImpl implements ConsultaConselhoService {

    private final ConselhoRepository repository;

    @Override
    public Conselho consultar(Long conselhoId) {

        return repository.findById(conselhoId).orElseThrow(() -> new InformacaoNaoEncontradaException(null, HttpStatus.NO_CONTENT));

    }
}
