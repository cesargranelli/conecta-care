package com.sevenine.conecta.adapter.controller.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class MoedaRequest {

    private Long id;

    @Length(min = 1, max = 5, message = "O campo 'descricao' deverá conter no mínimo 5 caracteres e no máximo 5")
    private String descricao;

}
