package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.atendimento.ConsultaAtendimentoDetalheResponse;

public interface ConsultaAtendimentoDetalheUseCase {
    ConsultaAtendimentoDetalheResponse executar(Long idAtendimento);
}
