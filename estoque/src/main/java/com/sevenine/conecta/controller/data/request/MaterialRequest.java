package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class MaterialRequest {

    @Length(min = 1, max = 100, message = "O campo 'nome' deverá conter no mínimo 1 caracter e no máximo 100")
    private String nome;

    @Length(min = 1, max = 100, message = "O campo 'descricao' deverá conter no mínimo 1 caracter e no máximo 100")
    private String descricao;

    @Valid
    private CategoriaRequest categoria;

    @Valid
    private SubCategoriaRequest subCategoria;

    @Length(min = 13, max = 13, message = "O campo 'codigoBarras' deverá ser um número inteiro de exatos 13 algarismos")
    @Pattern(regexp = "[\\d]{0,}", message = "O campo 'codigoBarras' aceita apenas números")
    private String codigoBarras;

    private String foto;

}
