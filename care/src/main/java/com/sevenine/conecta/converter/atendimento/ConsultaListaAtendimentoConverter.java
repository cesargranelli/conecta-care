package com.sevenine.conecta.converter.atendimento;

import com.sevenine.conecta.controller.data.response.atendimento.AtendimentoResumoResponse;
import com.sevenine.conecta.repository.data.Atendimento;

import java.util.List;

public interface ConsultaListaAtendimentoConverter {
    List<AtendimentoResumoResponse> fromEntityDataList(List<Atendimento> atendimentos);
}
