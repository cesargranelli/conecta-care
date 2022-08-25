package com.sevenine.conecta.controllers.data.request.tratamento;

import com.sevenine.conecta.controllers.data.request.atendimento.GeneroRequest;
import com.sevenine.conecta.controllers.data.request.atendimento.ParentescoRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AdicionaAcompanhanteRequest {
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private GeneroRequest genero;
    private ParentescoRequest parentesco;
    private ContatoRequest contato;
    private Long pacienteId;
}
