package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.atendimento.AdicionaAtendimentoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.AdicionaAtendimentoSituacaoRequest;
import com.sevenine.conecta.enumerator.StatusAtendimentoEnum;
import com.sevenine.conecta.mapper.atendimento.AdicionaAtendimentosMapper;
import com.sevenine.conecta.repository.AtendimentoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.service.AdicionaAtendimentoSituacaoService;
import com.sevenine.conecta.service.AdicionaAtendimentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdicionaAtendimentosServiceImpl implements AdicionaAtendimentosService {

    private final AdicionaAtendimentosMapper mapper;

    private final AtendimentoRepository repository;

    private final AdicionaAtendimentoSituacaoService adicionaAtendimentoSituacaoService;

    @Override
    public void adicionar(List<AdicionaAtendimentoRequest> requests) {
        List<Atendimento> atendimentos = mapper.toEntityDataList(requests);

        atendimentos.forEach(atendimento -> {
            Atendimento atendimentoSave = repository.save(atendimento);

            adicionaAtendimentoSituacaoService.adicionar(adicionaAtendimentoSituacaoRequest(requests), atendimentoSave);
        });
    }

    private AdicionaAtendimentoSituacaoRequest adicionaAtendimentoSituacaoRequest(List<AdicionaAtendimentoRequest> requests) {
        return requests.stream().findAny().orElse(adicionaAtendimentoRequest()).getSituacao();
    }

    private AdicionaAtendimentoRequest adicionaAtendimentoRequest() {
        AdicionaAtendimentoSituacaoRequest adicionaAtendimentoSituacaoRequest = new AdicionaAtendimentoSituacaoRequest();
        adicionaAtendimentoSituacaoRequest.setDataHora(LocalDateTime.now());
        adicionaAtendimentoSituacaoRequest.setStatus(StatusAtendimentoEnum.AGENDADO.getDescricao());

        AdicionaAtendimentoRequest adicionaAtendimentoRequest = new AdicionaAtendimentoRequest();
        adicionaAtendimentoRequest.setSituacao(adicionaAtendimentoSituacaoRequest);

        return adicionaAtendimentoRequest;
    }

}
