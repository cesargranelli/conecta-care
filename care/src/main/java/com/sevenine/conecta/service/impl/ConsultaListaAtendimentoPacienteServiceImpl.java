package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.mapper.atendimento.ConsultaListaAtendimentoPacienteServiceMapper;
import com.sevenine.conecta.repository.AtendimentoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.services.ConsultaListaAtendimentoPacienteService;
import com.sevenine.conecta.services.data.response.AtendimentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaListaAtendimentoPacienteServiceImpl implements ConsultaListaAtendimentoPacienteService {

    private final ConsultaListaAtendimentoPacienteServiceMapper mapper;

    private final AtendimentoRepository repository;

    @Override
    public List<AtendimentoResponse> consultar(Long pacienteId) {
        Optional<List<Atendimento>> optional = repository.findByPacienteId(pacienteId);

        return mapper.fromEntityDataList(optional.orElseThrow(() -> new NaoLocalizadoException(null, HttpStatus.NO_CONTENT)));
    }

}
