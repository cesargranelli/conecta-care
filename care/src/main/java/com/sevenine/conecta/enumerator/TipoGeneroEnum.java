package com.sevenine.conecta.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoGeneroEnum {
    M(GeneroEnum.MASCULINO), F(GeneroEnum.FEMININO);

    private final GeneroEnum genero;
}
