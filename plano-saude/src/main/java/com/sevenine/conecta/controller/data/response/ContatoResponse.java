package com.sevenine.conecta.controllers.data.response;

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
    private final String telefoneOuvidoria;
    private final String email;
    private final String site;
    private final boolean flagAceiteDeclaracao;
    private final boolean flagAceitePrivacidade;
    private final Long idPlanoSaude;
}
