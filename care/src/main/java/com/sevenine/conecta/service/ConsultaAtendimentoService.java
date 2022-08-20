package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.AtendimentoDetalheResponse;

public interface ConsultaAtendimentoService {
    AtendimentoDetalheResponse consultar(Long idAtendimento);
}
