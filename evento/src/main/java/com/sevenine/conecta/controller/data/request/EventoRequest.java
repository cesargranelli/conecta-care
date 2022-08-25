package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class EventoRequest {
    private String titulo;
    private String descricao;
    private String detalhe;
    private LocalDate data;
    private LocalTime hora;
    private String logradouro;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private int duracao;
    private int vagas;
    private EstadoRequest estado;
    private List<AreaAtendimentoRequest> areasAtendimento;
    private String usuario;
}
