package com.sevenine.conecta.adapter.controller.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaResponse {
    private Long id;
    private TipoContaResponse tipo;
    private BancoResponse banco;
    private String agencia;
    private String numero;
    private String digito;
    private String chavePixPrimaria;
    private String chavePixSecundaria;
}
