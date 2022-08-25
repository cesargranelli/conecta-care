package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.data.request.tratamento.EncerraTratamentoRequest;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.repository.TratamentoRepository;
import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.services.EncerraTratamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EncerraTratamentoServiceImpl implements EncerraTratamentoService {

    private final TratamentoRepository repository;

    @Override
    public void encerrar(EncerraTratamentoRequest request) {
        Optional<Tratamento> optional = repository.findById(request.getTratamentoId());

        Tratamento tratamento = optional.orElseThrow(() -> new NaoLocalizadoException(null, HttpStatus.NO_CONTENT));

        tratamento.setObservacao(request.getObservacao());
        repository.flush();
    }

}
