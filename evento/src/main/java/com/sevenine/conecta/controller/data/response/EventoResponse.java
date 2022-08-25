package com.sevenine.conecta.controllers.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class EventoResponse {
    private long id;
    private String titulo;
    private String descricao;
    private String detalhe;
    private LocalDate data;
    private LocalTime hora;
    private LocalDateTime dataCadastro;
    private String usuarioCadastro;
    private LocalDateTime dataAtualizacao;
    private String usuarioAtualizacao;
    private String logradouro;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private int duracao;
    private int vagas;
    private String status;
    private EstadoResponse estado;
    private List<EspecialidadeResponse> especialidades;
}
