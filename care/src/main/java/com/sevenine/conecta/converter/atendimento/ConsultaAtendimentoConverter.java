package com.sevenine.conecta.converter.atendimento;

import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.service.data.response.AtendimentoDetalheResponse;

public interface ConsultaAtendimentoConverter {
    AtendimentoDetalheResponse fromEntityData(Atendimento atendimento);
}
