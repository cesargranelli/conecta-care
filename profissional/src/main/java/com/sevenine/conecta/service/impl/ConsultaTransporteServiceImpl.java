package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.repository.TransporteRepository;
import com.sevenine.conecta.repository.data.Transporte;
import com.sevenine.conecta.services.ConsultaTransporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsultaTransporteServiceImpl implements ConsultaTransporteService {

    private final TransporteRepository repository;

    @Override
    public Transporte consultar(Long transporteId) {

        return repository.findById(transporteId).orElseThrow(() -> new InformacaoNaoEncontradaException(null, HttpStatus.NO_CONTENT));

    }

}
