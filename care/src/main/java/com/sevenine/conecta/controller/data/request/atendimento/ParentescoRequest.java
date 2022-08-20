package com.sevenine.conecta.controller.data.request.atendimento;

import com.sevenine.conecta.enumerator.ParentescoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ParentescoRequest {

    @NotNull(message = "O campo id do objeto 'parentesco' é obrigatório")
    private Long id;

    private ParentescoEnum descricao;

}
