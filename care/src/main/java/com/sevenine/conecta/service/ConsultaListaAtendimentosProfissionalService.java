package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.AtendimentoResponse;

import java.time.LocalDate;
import java.util.List;

public interface ConsultaListaAtendimentosProfissionalService {
    List<AtendimentoResponse> listar(Long profissionalId, LocalDate dataAtendimento);
    List<AtendimentoResponse> listarPorPeriodo(Long profissionalId, LocalDate dataInicio, LocalDate dataFim);
}
