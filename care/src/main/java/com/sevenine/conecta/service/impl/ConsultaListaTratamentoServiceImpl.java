package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.mapper.tratamento.ConsultaListaTratamentoMapper;
import com.sevenine.conecta.repository.TratamentoRepository;
import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.services.ConsultaListaTratamentoService;
import com.sevenine.conecta.services.data.response.TratamentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaListaTratamentoServiceImpl implements ConsultaListaTratamentoService {

    private final ConsultaListaTratamentoMapper mapper;

    private final TratamentoRepository repository;

    @Override
    public List<TratamentoResponse> consultar(Long pacienteId, Long homeCareId) {
        Optional<List<Tratamento>> optional = repository.findByPacienteIdAndHomeCareId(pacienteId, homeCareId);

        return mapper.fromEntityDataList(optional.orElseThrow(() -> new NaoLocalizadoException(null, HttpStatus.NO_CONTENT)));
    }

}
