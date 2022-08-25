package com.sevenine.conecta.controllers.data.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EstadoResponse {
    private final Long id;
    private final String codigo;
    private final String uf;
    private final String nome;
    private final String regiao;
}
