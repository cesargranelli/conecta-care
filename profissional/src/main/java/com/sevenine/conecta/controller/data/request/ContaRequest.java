package com.sevenine.conecta.adapter.controller.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaRequest {
    private Long id;
    private TipoContaRequest tipo;
    private BancoRequest banco;
    private String agencia;
    private String numero;
    private String digito;
    private String chavePixPrimaria;
    private String chavePixSecundaria;
    private Long proprietarioId;
}
