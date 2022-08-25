package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class HomeCareRequest {
    private Long id;
    private String nome;
    private String cnpj;
    private String site;
    private String tipoDocumento;
    private List<EspecialidadeRequest> especialidades;
}
