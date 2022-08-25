package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.AtendimentoDetalheResponse;

public interface ConsultaAtendimentoService {
    AtendimentoDetalheResponse consultar(Long idAtendimento);
}
