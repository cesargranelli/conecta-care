package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.mapper.atendimento.ConsultaListaAtendimentoProfissionalServiceMapper;
import com.sevenine.conecta.repository.AtendimentoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.service.ConsultaListaAtendimentosProfissionalService;
import com.sevenine.conecta.service.data.response.AtendimentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ConsultaListaAtendimentosProfissionalServiceImpl implements ConsultaListaAtendimentosProfissionalService {

    private final ConsultaListaAtendimentoProfissionalServiceMapper mapper;

    private final AtendimentoRepository atendimentoRepository;

    @Override
    public List<AtendimentoResponse> listar(Long profissionalId, LocalDate dataAtendimento) {
        Optional<List<Atendimento>> atendimentos =
                atendimentoRepository.findByProfissionalIdAndData(profissionalId, dataAtendimento);

        return atendimentos.orElseThrow(() -> new NaoLocalizadoException(null, HttpStatus.NO_CONTENT)).stream()
                .map(mapper::fromEntityData).collect(Collectors.toList());
    }

    @Override
    public List<AtendimentoResponse> listarPorPeriodo(Long profissionalId, LocalDate dataInicio, LocalDate dataFim) {
        Optional<List<Atendimento>> atendimentos =
                atendimentoRepository.findByProfissionalIdAndDataBetween(profissionalId, dataInicio, dataFim);

        return atendimentos.orElseThrow(() -> new NaoLocalizadoException(null, HttpStatus.NO_CONTENT)).stream()
                .map(mapper::fromEntityData).collect(Collectors.toList());
    }
    
}
