package com.sevenine.conecta.service.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoResponse {
    private Long id;
    private String telefoneFixo;
    private String telefoneRecado;
    private String telefoneCelular;
    private String telefoneResponsavel;
    private String emailResponsavel;
}
