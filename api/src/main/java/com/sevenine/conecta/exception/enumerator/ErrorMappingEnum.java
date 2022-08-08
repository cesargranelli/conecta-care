package com.sevenine.conecta.exception.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMappingEnum {

    ERRO_AO_COMUNICAR_COM_SERVICO("Erro ao comunicar com serviço"),
    ERRO_ACESSO_NEGADO("Acesso negado");

    private final String mensagem;

}
