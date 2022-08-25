package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.converter.atendimento.ConsultaAtendimentoConverter;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.repository.AtendimentoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.services.ConsultaAtendimentoService;
import com.sevenine.conecta.services.data.response.AtendimentoDetalheResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaAtendimentoServiceImpl implements ConsultaAtendimentoService {

    private final ConsultaAtendimentoConverter converter;

    private final AtendimentoRepository repository;

    @Override
    public AtendimentoDetalheResponse consultar(Long idAtendimento) {
        Optional<Atendimento> optional = repository.findById(idAtendimento);

        return converter.fromEntityData(optional.orElseThrow(() -> new NaoLocalizadoException(null, HttpStatus.NO_CONTENT)));
    }

}
