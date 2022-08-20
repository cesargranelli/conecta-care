package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.AtendimentoResponse;

import java.time.LocalDate;
import java.util.List;

public interface ConsultaListaAtendimentosProfissionalService {
    List<AtendimentoResponse> listar(Long profissionalId, LocalDate dataAtendimento);
    List<AtendimentoResponse> listarPorPeriodo(Long profissionalId, LocalDate dataInicio, LocalDate dataFim);
}
