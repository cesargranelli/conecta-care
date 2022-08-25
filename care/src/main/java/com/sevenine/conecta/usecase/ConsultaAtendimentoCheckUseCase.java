package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.atendimento.AtendimentoCheckResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ConsultaAtendimentoCheckUseCase {

    List<AtendimentoCheckResponse> executar(Optional<LocalDate> data, Long id);

}
