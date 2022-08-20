package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.tratamento.TratamentoSituacaoRequest;
import com.sevenine.conecta.repository.StatusTratamentoRepository;
import com.sevenine.conecta.repository.TratamentoRepository;
import com.sevenine.conecta.repository.TratamentoSituacaoRepository;
import com.sevenine.conecta.repository.data.TratamentoSituacao;
import com.sevenine.conecta.service.AdicionaTratamentoSituacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdicionaTratamentoSituacaoServiceImpl implements AdicionaTratamentoSituacaoService {

    private final TratamentoSituacaoRepository repository;
    private final TratamentoRepository tratamentoRepository;
    private final StatusTratamentoRepository statusTratamentoRepository;

    @Override
    public void adicionar(TratamentoSituacaoRequest request, Long tratamentoId) {
        TratamentoSituacao tratamentoSituacao = new TratamentoSituacao();
        tratamentoSituacao.setTratamento(tratamentoRepository.getOne(tratamentoId));
        tratamentoSituacao.setStatus(statusTratamentoRepository.findByDescricao(request.getStatus()));
        repository.save(tratamentoSituacao);
    }

}
