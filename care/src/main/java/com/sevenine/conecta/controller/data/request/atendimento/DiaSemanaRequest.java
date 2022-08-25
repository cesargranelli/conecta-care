package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaSemanaRequest {
    private Long id;
    private String sigla;
    private String descricao;
}
