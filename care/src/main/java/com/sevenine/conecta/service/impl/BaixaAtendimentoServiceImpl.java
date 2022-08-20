package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.atendimento.AdicionaAtendimentoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.AdicionaAtendimentoSituacaoRequest;
import com.sevenine.conecta.controller.data.request.atendimento.BaixaRequest;
import com.sevenine.conecta.enumerator.StatusAtendimentoEnum;
import com.sevenine.conecta.exception.AtendimentoRuntimeException;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.repository.AtendimentoRepository;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.service.AdicionaAtendimentoSituacaoService;
import com.sevenine.conecta.service.AdicionaCamposBaixaAtendimentoService;
import com.sevenine.conecta.service.BaixaAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class BaixaAtendimentoServiceImpl implements BaixaAtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    private final AdicionaAtendimentoSituacaoService adicionaAtendimentoSituacaoService;
    private final AdicionaCamposBaixaAtendimentoService adicionaCamposBaixaAtendimentoService;

    @Override
    public void baixar(BaixaRequest request) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(request.getAtendimentoId());
        if (!atendimento.isPresent())
            throw new NaoLocalizadoException(null, HttpStatus.NO_CONTENT);

        if (atendimento.get().statusRecente().getDescricao().equals(StatusAtendimentoEnum.FINALIZADO.getDescricao()))
            throw new AtendimentoRuntimeException("Atendimento já foi baixado", HttpStatus.PRECONDITION_FAILED);

        atendimento.get().setAssinatura(request.getAssinatura());
        atendimento.get().setObservacoesBaixa(request.getObservacoes());

        atendimentoRepository.save(atendimento.get());

        adicionaAtendimentoSituacaoService.adicionar(adicionaAtendimentoRequest().getSituacao(), atendimento.get());

        adicionaCamposBaixaAtendimentoService.adicionar(request.getGrupos(), request.getFotos(), atendimento.get().getId());
    }

    private AdicionaAtendimentoRequest adicionaAtendimentoRequest() {
        AdicionaAtendimentoSituacaoRequest adicionaAtendimentoSituacaoRequest = new AdicionaAtendimentoSituacaoRequest();
        adicionaAtendimentoSituacaoRequest.setDataHora(LocalDateTime.now());
        adicionaAtendimentoSituacaoRequest.setStatus(StatusAtendimentoEnum.FINALIZADO.getDescricao());

        AdicionaAtendimentoRequest adicionaAtendimentoRequest = new AdicionaAtendimentoRequest();
        adicionaAtendimentoRequest.setSituacao(adicionaAtendimentoSituacaoRequest);

        return adicionaAtendimentoRequest;
    }

}
