package com.sevenine.conecta.adapter.controller.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PlantonistaRequest {

    private Long id;

    @NotBlank(message = "O campo nome do objeto 'plantonista' é obrigatório")
    private String nome;

    @NotBlank(message = "O campo contato do objeto 'plantonista' é obrigatório")
    private String contato;

}
