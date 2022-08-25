package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UnidadeMedidaRequest {

    private Long id;

    @Length(min = 5, max = 5, message = "O campo 'descricao' deverá conter 5 caracteres")
    @Pattern(regexp = "[A-Z]+", message = "O campo 'descricao' deverá conter apenas caracteres maiúsculos")
    @NotNull(message = "O campo 'descricao' não pode ser nulo")
    private String descricao;

}
