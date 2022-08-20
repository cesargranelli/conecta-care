package com.sevenine.conecta.controller.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RecorrenciaSemanalRequest {
    private LocalDate inicio;
    private LocalDate fim;
    private List<DiaSemanaRequest> dias;
}
