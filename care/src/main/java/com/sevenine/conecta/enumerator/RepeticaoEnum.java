package com.sevenine.conecta.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RepeticaoEnum {
    DIARIA("1"),
    SEMANAL("7");

    private final String codigo;
}
