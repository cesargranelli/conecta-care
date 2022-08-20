package com.sevenine.conecta.controller.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequest {
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String comprovante;
    private String ctpsSerie;
    private String estado;
    private String pais;
    private Long proprietarioId;
}
