package com.sevenine.conecta.usecase;

import com.sevenine.conecta.adapter.controller.data.response.atendimento.ConsultaAtendimentoDetalheResponse;

public interface ConsultaAtendimentoDetalheUseCase {
    ConsultaAtendimentoDetalheResponse executar(Long idAtendimento);
}
