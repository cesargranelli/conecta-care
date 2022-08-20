package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.atendimento.AtendimentoResumoResponse;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestHeader;

public interface ConsultaListaAtendimentoResumoUseCase {
    List<AtendimentoResumoResponse> executar(Long homeCareId, LocalDate dataConsulta);
}
