package com.sevenine.conecta.adapter.controller.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class SubCategoriaRequest {

    private Long id;

    @Length(min = 1, max = 40, message = "O campo 'descricao' deverá conter no máximo 40 caracteres")
    private String descricao;

}
