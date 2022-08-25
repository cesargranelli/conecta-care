package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.repository.EstadoRepository;
import com.sevenine.conecta.repository.data.Estado;
import com.sevenine.conecta.services.ConsultaEstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsultaEstadoServiceImpl implements ConsultaEstadoService {

    private final EstadoRepository repository;

    @Override
    public Estado consultar(Long estadoId) {
        return repository.findById(estadoId).orElseThrow(() -> new InformacaoNaoEncontradaException(null, HttpStatus.NO_CONTENT));
    }

}
