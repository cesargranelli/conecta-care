package com.sevenine.conecta.controller.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PaisRequest {

    @NotNull(message = "O campo id do objeto 'pais' é obrigatório")
    private Long id;

    @NotBlank(message = "O campo codigo do objeto 'pais' é obrigatório")
    private String codigo;

    @NotBlank(message = "O campo nome do objeto 'pais' é obrigatório")
    private String nome;

}
