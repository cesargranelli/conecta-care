package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.controller.data.request.atendimento.AdicionaAtendimentoSituacaoRequest;
import com.sevenine.conecta.repository.AtendimentoSituacaoRepository;
import com.sevenine.conecta.repository.StatusAtendimentoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.repository.data.AtendimentoSituacao;
import com.sevenine.conecta.services.AdicionaAtendimentoSituacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdicionaAtendimentoSituacaoServiceImpl implements AdicionaAtendimentoSituacaoService {

    private final AtendimentoSituacaoRepository repository;
    private final StatusAtendimentoRepository statusAtendimentoRepository;

    @Override
    public void adicionar(AdicionaAtendimentoSituacaoRequest request, Atendimento atendimento) {
        AtendimentoSituacao atendimentoSituacao = new AtendimentoSituacao();
        atendimentoSituacao.setAtendimento(atendimento);
        atendimentoSituacao.setDataHora(request.getDataHora());
        atendimentoSituacao.setStatus(statusAtendimentoRepository.findByDescricao(request.getStatus()));
        repository.save(atendimentoSituacao);
    }

}
