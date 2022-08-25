package com.sevenine.conecta.converter.atendimento;

import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.services.data.response.AtendimentoDetalheResponse;

public interface ConsultaAtendimentoConverter {
    AtendimentoDetalheResponse fromEntityData(Atendimento atendimento);
}
