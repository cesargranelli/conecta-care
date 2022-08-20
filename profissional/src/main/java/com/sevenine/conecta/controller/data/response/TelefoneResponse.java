package com.sevenine.conecta.controller.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneResponse {
    private Long id;
    private String telefoneFixo;
    private String telefoneRecado;
    private String celularPrincipal;
    private String celularSecundario;
}
