package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProfissionalRequest {

    @NotNull(message = "O campo id do objeto 'profissional' é obrigatório")
    private Long id;

    private String cpf;

}
