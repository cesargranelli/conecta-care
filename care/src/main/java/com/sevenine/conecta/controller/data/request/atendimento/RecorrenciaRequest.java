package com.sevenine.conecta.controllers.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecorrenciaRequest {
    private RecorrenciaDiariaRequest diaria;
    private RecorrenciaSemanalRequest semanal;
}
