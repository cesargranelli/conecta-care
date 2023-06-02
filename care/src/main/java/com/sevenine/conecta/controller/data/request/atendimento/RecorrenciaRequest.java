package com.sevenine.conecta.adapter.controller.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecorrenciaRequest {
    private RecorrenciaDiariaRequest diaria;
    private RecorrenciaSemanalRequest semanal;
}
