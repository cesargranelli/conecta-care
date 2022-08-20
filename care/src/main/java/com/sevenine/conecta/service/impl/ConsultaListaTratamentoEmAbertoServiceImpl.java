package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.mapper.tratamento.ConsultaListaTratamentoEmAbertoMapper;
import com.sevenine.conecta.repository.TratamentoRepository;
import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.service.ConsultaListaTratamentoEmAbertoService;
import com.sevenine.conecta.service.data.response.ConsultaListaTratamentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaListaTratamentoEmAbertoServiceImpl implements ConsultaListaTratamentoEmAbertoService {

    private final ConsultaListaTratamentoEmAbertoMapper mapper;

    private final TratamentoRepository repository;

    @Override
    public List<ConsultaListaTratamentoResponse> consultar(Long homeCareId) {
        Optional<List<Tratamento>> optionalList = repository.findByHomeCareIdAndObservacaoNullAndSituacoesStatusDescricao(homeCareId, "ABERTO");

        return mapper.fromEntityDataList(optionalList.orElseThrow(() -> new NaoLocalizadoException(null, HttpStatus.NO_CONTENT)));
    }

}
