package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaRequest {

    private Long id;

    @Length(min = 1, max = 20, message = "O campo 'descricao' deverá conter no máximo 20 caracteres")
    private String descricao;

}
