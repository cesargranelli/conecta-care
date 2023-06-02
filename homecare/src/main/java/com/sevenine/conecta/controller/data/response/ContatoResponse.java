package com.sevenine.conecta.adapter.controller.data.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContatoResponse {
    private final Long id;
    private final String telefoneFixo;
    private final String telefoneRecado;
    private final String telefoneCelular;
    private final String telefoneWhatsapp;
    private final String email;
    private final boolean flagAceiteDeclaracao;
    private final boolean flagAceitePrivacidade;
    private final Long idHomeCare;
}
