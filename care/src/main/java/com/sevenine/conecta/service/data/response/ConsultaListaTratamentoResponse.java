package com.sevenine.conecta.services.data.response;

import com.sevenine.conecta.repository.data.StatusTratamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaListaTratamentoResponse {
    private Long id;
    private String descricao;
    private StatusTratamento status;
    private Long pacienteId;
}
