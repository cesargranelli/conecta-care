package com.sevenine.conecta.http.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class AcompanhanteResponseResource {

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeCompleto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate dataNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GeneroResource genero;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ParentescoResource parentesco;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContatoResource contato;

}
