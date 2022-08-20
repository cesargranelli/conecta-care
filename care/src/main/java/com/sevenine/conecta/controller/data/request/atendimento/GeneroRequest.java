package com.sevenine.conecta.controller.data.request.atendimento;

import com.sevenine.conecta.enumerator.GeneroEnum;
import com.sevenine.conecta.enumerator.TipoGeneroEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GeneroRequest {

    @NotNull(message = "O campo id do objeto 'genero' é obrigatório")
    private Long id;

    private TipoGeneroEnum tipo;
    private GeneroEnum descricao;

}
