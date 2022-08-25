package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class AcompanhanteRequest {

    private Long id;

    @NotBlank(message = "O campo nome do objeto 'acompanhante' é obrigatório")
    private String nome;

    @NotBlank(message = "O campo sobrenome do objeto 'acompanhante' é obrigatório")
    private String sobrenome;

    @NotBlank(message = "O campo cpf do objeto 'acompanhante' é obrigatório")
    private String cpf;

    @NotNull(message = "O campo dataNascimento do objeto 'acompanhante' é obrigatório")
    private LocalDate dataNascimento;

    @Valid
    @NotNull(message = "O objeto genero do objeto 'acompanhante' é obrigatório")
    private GeneroRequest genero;

    @Valid
    @NotNull(message = "O objeto parentesco do objeto 'acompanhante' é obrigatório")
    private ParentescoRequest parentesco;

    @Valid
    @NotNull(message = "O objeto contato do objeto 'acompanhante' é obrigatório")
    private ContatoRequest contato;

}
