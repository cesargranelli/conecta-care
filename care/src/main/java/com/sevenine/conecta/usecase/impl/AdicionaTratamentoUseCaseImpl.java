package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.request.tratamento.AdicionaTratamentoRequest;
import com.sevenine.conecta.exception.ExisteTratamentoEmAbertoException;
import com.sevenine.conecta.exception.NaoExisteTratamentoEmAbertoException;
import com.sevenine.conecta.exception.NaoLocalizadoException;
import com.sevenine.conecta.services.AdicionaTratamentoService;
import com.sevenine.conecta.services.CadastraAcompanhanteService;
import com.sevenine.conecta.services.ConsultaTratamentoEmAbertoService;
import com.sevenine.conecta.services.AdicionaTratamentoSituacaoService;
import com.sevenine.conecta.usecase.AdicionaTratamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Component
public class AdicionaTratamentoUseCaseImpl implements AdicionaTratamentoUseCase {

    private final ConsultaTratamentoEmAbertoService consultaTratamentoEmAbertoService;
    private final CadastraAcompanhanteService cadastraAcompanhanteService;
    private final AdicionaTratamentoService adicionaTratamentoService;
    private final AdicionaTratamentoSituacaoService adicionaTratamentoSituacaoService;

    @Override
    public void executar(AdicionaTratamentoRequest request) {
        try {
            consultaTratamentoEmAbertoService.consultar(request.getPacienteId(), request.getHomeCareId());
            throw new ExisteTratamentoEmAbertoException("Paciente já possui um tratamento em aberto", HttpStatus.PRECONDITION_FAILED);
        } catch (NaoLocalizadoException | NaoExisteTratamentoEmAbertoException e) {
            if (!isNull(request.getAcompanhante())) {
                request.getAcompanhante().setPacienteId(request.getPacienteId());
                request.setAcompanhanteId(cadastraAcompanhanteService.cadastrar(request.getAcompanhante()));
            }

            Long tratamentoId = adicionaTratamentoService.adicionar(request);

            adicionaTratamentoSituacaoService.adicionar(request.getSituacao(), tratamentoId);
        }
    }

}
