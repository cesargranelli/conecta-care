package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.response.atendimento.AtendimentoCheckResponse;
import com.sevenine.conecta.converter.atendimento.ConsultaAtendimentoConverter;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.mapper.atendimento.ConsultaAtendimentoMapper;
import com.sevenine.conecta.repository.AtendimentoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.services.ConsultaAtendimentoCheckService;
import com.sevenine.conecta.services.data.response.AtendimentoDetalheResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultaAtendimentoCheckServiceImpl implements ConsultaAtendimentoCheckService {

    private final ConsultaAtendimentoMapper mapper;

    private final ConsultaAtendimentoConverter converter;

    private final AtendimentoRepository atendimentoRepository;

    @Override
    public List<AtendimentoCheckResponse> executar(Optional<LocalDate> data, Long id) {
        if(!data.isPresent())
            data = Optional.of(LocalDate.now());

        Optional<List<Atendimento>> atendimentos = atendimentoRepository.findByProfissionalIdAndData(id, data.get());

        if(!atendimentos.isPresent())
            throw new NaoLocalizadoException(null, HttpStatus.NO_CONTENT);

        List<AtendimentoCheckResponse> response = new ArrayList<>();
        atendimentos.get().forEach(e -> response.add(mapper.fromEntityToAtendimentoCheck(e)));
        return response;
    }

}
