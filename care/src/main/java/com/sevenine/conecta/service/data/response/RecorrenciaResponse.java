package com.sevenine.conecta.services.data.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RecorrenciaResponse {
    private Long id;
    private LocalDate inicio;
    private LocalDate fim;
    private Integer quantidade;
    private String repeticao;
    private List<SemanaResponse> semanas;
}
