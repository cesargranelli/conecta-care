package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampoBaixaRequest {
    private Long id;
    private String tipo;
    private String valor;
}
