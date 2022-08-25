package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.exception.NaoExisteTratamentoEmAbertoException;
import com.sevenine.conecta.mapper.tratamento.ConsultaTratamentoMapper;
import com.sevenine.conecta.repository.TratamentoRepository;
import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.services.ConsultaTratamentoEmAbertoService;
import com.sevenine.conecta.services.data.response.TratamentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaTratamentoEmAbertoServiceImpl implements ConsultaTratamentoEmAbertoService {

    private final ConsultaTratamentoMapper mapper;

    private final TratamentoRepository repository;

    @Override
    public TratamentoResponse consultar(Long pacienteId, Long homeCareId) {
        Optional<Tratamento> optional = repository.findFirst1ByPacienteIdAndHomeCareIdAndObservacaoNullAndSituacoesStatusDescricaoOrderBySituacoesDataHoraDesc(pacienteId, homeCareId, "ABERTO");

        return mapper.fromEntityData(optional.orElseThrow(() -> new NaoExisteTratamentoEmAbertoException("Não existe tratamento em aberto para encerrar", HttpStatus.PRECONDITION_FAILED)));
    }

}
