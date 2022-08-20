package com.sevenine.conecta.controller.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContatoRequest {
    private Long id;
    private String telefoneFixo;
    private String telefoneRecado;
    private String telefoneCelular;
    private String telefoneWhatsapp;
    private String telefoneOuvidoria;
    private String email;
    private String site;
    private String flagAceiteDeclaracao;
    private String flagAceitePrivacidade;
    private Long idPlanoSaude;
}
