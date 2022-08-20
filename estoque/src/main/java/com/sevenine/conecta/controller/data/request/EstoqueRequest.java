package com.sevenine.conecta.controller.data.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class EstoqueRequest {

    @Valid
    private UnidadeMedidaRequest unidadeMedida;

    @Digits(integer = 5, fraction = 0, message = "O campo 'quantidade' deverá conter no máximo 5 números")
    private int quantidade;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataUltimaCompra;

}
