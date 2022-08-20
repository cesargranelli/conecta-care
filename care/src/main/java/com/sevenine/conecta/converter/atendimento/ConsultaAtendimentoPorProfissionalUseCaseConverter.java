package com.sevenine.conecta.converter.atendimento;

import com.sevenine.conecta.service.data.response.*;

public interface ConsultaAtendimentoPorProfissionalUseCaseConverter {
    ProfissionalAtendimentoResponse toResponse(AtendimentoResponse atendimento,
                                               PacienteResponse paciente,
                                               AcompanhanteResponse acompanhante,
                                               AtendimentoProfissionalResponse profissional);
}
