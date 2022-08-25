package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RecorrenciaDiariaRequest {
    private LocalDate inicio;
    private LocalDate fim;
    private Integer quantidade;
}
