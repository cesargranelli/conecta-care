package com.sevenine.conecta.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCadastro {
    PENDENTE(1), INCOMPLETO(2), COMPLETO(3);

    private final int id;
}
