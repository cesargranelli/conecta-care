package com.sevenine.conecta.controller.data.response.tratamento;

import com.sevenine.conecta.service.data.response.ContatoResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ConsultaTratamentoAcompanhanteResponse {
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String genero;
    private String parentesco;
    private ContatoResponse contato;
}
