package com.sevenine.conecta.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDocumento {
    CPF(11), CNPJ(14);

    private final int length;
}
