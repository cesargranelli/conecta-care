package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EstadoRequest {

    @NotNull(message = "O campo id do objeto 'estado' é obrigatório")
    private Long id;

    @NotBlank(message = "O campo codigo do objeto 'estado' é obrigatório")
    private String codigo;

    @NotBlank(message = "O campo uf do objeto 'estado' é obrigatório")
    private String uf;

    @NotBlank(message = "O campo nome do objeto 'estado' é obrigatório")
    private String nome;

    @NotBlank(message = "O campo regiao do objeto 'estado' é obrigatório")
    private String regiao;

}
