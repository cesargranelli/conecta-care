package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.response.atendimento.AtendimentoCheckResponse;
import com.sevenine.conecta.services.ConsultaAtendimentoCheckService;
import com.sevenine.conecta.usecase.ConsultaAtendimentoCheckUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ConsultaAtendimentoCheckUseCaseImpl implements ConsultaAtendimentoCheckUseCase {

    private final ConsultaAtendimentoCheckService consultaAtendimentoCheckService;

    @Override
    public List<AtendimentoCheckResponse> executar(Optional<LocalDate> data, Long id) {
        return consultaAtendimentoCheckService.executar(data, id);
    }

}
