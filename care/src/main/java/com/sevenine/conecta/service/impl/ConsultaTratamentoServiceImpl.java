package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.mapper.tratamento.ConsultaTratamentoMapper;
import com.sevenine.conecta.repository.TratamentoRepository;
import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.services.ConsultaTratamentoService;
import com.sevenine.conecta.services.data.response.TratamentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaTratamentoServiceImpl implements ConsultaTratamentoService {

    private final ConsultaTratamentoMapper mapper;

    private final TratamentoRepository repository;

    @Override
    public TratamentoResponse consultar(Long tratamentoId) {
        Optional<Tratamento> optional = repository.findById(tratamentoId);

        return mapper.fromEntityData(optional.orElseThrow(() -> new NaoLocalizadoException(null, HttpStatus.NO_CONTENT)));
    }

}
