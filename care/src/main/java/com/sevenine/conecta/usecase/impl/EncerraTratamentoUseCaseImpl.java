package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.request.tratamento.EncerraTratamentoRequest;
import com.sevenine.conecta.services.AdicionaTratamentoSituacaoService;
import com.sevenine.conecta.services.ConsultaTratamentoEmAbertoService;
import com.sevenine.conecta.services.ConsultaTratamentoService;
import com.sevenine.conecta.services.EncerraTratamentoService;
import com.sevenine.conecta.services.data.response.TratamentoResponse;
import com.sevenine.conecta.usecase.EncerraTratamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Component
public class EncerraTratamentoUseCaseImpl implements EncerraTratamentoUseCase {

    private final ConsultaTratamentoService consultaTratamentoService;
    private final ConsultaTratamentoEmAbertoService consultaTratamentoEmAbertoService;
    private final EncerraTratamentoService encerraTratamentoService;
    private final AdicionaTratamentoSituacaoService adicionaTratamentoSituacaoService;

    @Override
    public void executar(EncerraTratamentoRequest request) {
        TratamentoResponse tratamento = consultaTratamentoService.consultar(request.getTratamentoId());

        if (!isNull(consultaTratamentoEmAbertoService.consultar(tratamento.getPaciente().getId(), tratamento.getHomeCare().getId()))) {
            encerraTratamentoService.encerrar(request);
            adicionaTratamentoSituacaoService.adicionar(request.getSituacao(), request.getTratamentoId());
        }

    }

}
