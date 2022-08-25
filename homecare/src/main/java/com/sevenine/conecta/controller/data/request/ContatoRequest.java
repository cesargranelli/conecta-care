package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class ContatoRequest {
    private Long id;
    private String telefoneFixo;
    private String telefoneRecado;
    private String telefoneCelular;
    private String telefoneWhatsapp;
    private String email;
    private String flagAceiteDeclaracao;
    private String flagAceitePrivacidade;
    private Long idHomeCare;
}
