package com.sevenine.conecta.services.data.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampoResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tipo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tamanho;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pre;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pos;

    private String campoBaixa;
    
}
