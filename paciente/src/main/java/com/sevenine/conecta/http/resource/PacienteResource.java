package com.sevenine.conecta.controllers.resource;

import com.sevenine.conecta.repository.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class PacienteResource {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate dataNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String rg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String rgEmissor;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate rgDataEmissao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String foto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fotoRg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fotoCpf;

    private GeneroEntity genero;
    private EstadoCivilEntity estadoCivil;
    private EnderecoEntity endereco;
    private ContatoEntity contato;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private HistoricoMedicoEntity historicoMedico;
}
