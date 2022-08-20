package com.sevenine.conecta.controller.data.request.tratamento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ContatoRequest {

    private String telefoneFixo;
    private String telefoneRecado;

    @NotBlank(message = "O campo telefoneCelular do objeto 'contato' é obrigatório")
    private String telefoneCelular;

    private String telefoneResponsavel;
    private String emailResponsavel;

}
