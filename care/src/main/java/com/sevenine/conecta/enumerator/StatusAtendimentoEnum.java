package com.sevenine.conecta.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusAtendimentoEnum {
    AGENDADO("1", "AGENDADO"),
    DESLOCAMENTO("2", "DESLOCAMENTO"),
    DESLOCAMENTO_ATRASADO("3", "DESLOCAMENTO_ATRASADO"),
    CHECK_IN("4", "CHECK_IN"),
    CHECK_IN_ATRASADO("5", "CHECK_IN_ATRASADO"),
    CHECK_IN_MANUAL("6", "CHECK_IN_MANUAL"),
    CHECK_IN_MANUAL_ATRASADO("7", "CHECK_IN_MANUAL_ATRASADO"),
    ATRASADO("8", "ATRASADO"),
    CHECK_OUT("9", "CHECK_OUT"),
    CANCELADO("10", "CANCELADO"),
    FINALIZADO("11", "FINALIZADO");

    private final String codigo;
    private final String descricao;
}
