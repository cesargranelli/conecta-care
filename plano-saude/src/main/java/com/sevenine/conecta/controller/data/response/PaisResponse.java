package com.sevenine.conecta.controllers.data.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaisResponse {
    private final Long id;
    private final String codigo;
    private final String nome;
}
