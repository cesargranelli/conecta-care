package com.sevenine.conecta.controller.data.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EspecialidadeResponse {
    private final Long id;
    private final String nome;
}
