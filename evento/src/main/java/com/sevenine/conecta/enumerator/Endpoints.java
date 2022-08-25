package com.sevenine.conecta.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Endpoints {
    FILTRO_DADOS_SMS("filtroDadosSms"),
    CONFIRMA_EVENTO("confirmaEvento"),
    ENVIO_ABERTO("envioAberto");

    private final String alias;
}
