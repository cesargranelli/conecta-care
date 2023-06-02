package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.atendimento.AtendimentoResumoResponse;
import com.sevenine.conecta.repository.data.Atendimento;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ConsultaListaAtendimentoService {
    List<AtendimentoResumoResponse> consultar(Long idHomeCare, Map<String, LocalDate> periodoConsulta);
    
    List<Atendimento> consultarPorHomeCarePeriodo(Long idHomeCare, Map<String, LocalDate> periodoConsulta);
}
