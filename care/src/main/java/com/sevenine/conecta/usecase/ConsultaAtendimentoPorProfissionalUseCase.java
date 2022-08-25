package com.sevenine.conecta.usecase;

import com.sevenine.conecta.services.data.response.ProfissionalAtendimentoResponse;

import java.time.LocalDate;
import java.util.List;

public interface ConsultaAtendimentoPorProfissionalUseCase {

    List<ProfissionalAtendimentoResponse> executar(Long profissionalId, LocalDate dataAtendimento);
    
    List<ProfissionalAtendimentoResponse> executarPorPeriodo(Long profissionalId, LocalDate dataInicio, LocalDate dataFim);

}
