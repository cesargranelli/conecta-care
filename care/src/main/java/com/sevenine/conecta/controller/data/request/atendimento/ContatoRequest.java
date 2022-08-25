package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContatoRequest {

    private Long id;
    private String telefoneFixo;
    private String telefoneRecado;

    @NotBlank(message = "O campo telefoneCelular do objeto 'contato' é obrigatório")
    private String telefoneCelular;

    private String telefoneResponsavel;
    private String emailResponsavel;

}
