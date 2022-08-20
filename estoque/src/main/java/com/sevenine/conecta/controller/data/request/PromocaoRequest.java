package com.sevenine.conecta.controller.data.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PromocaoRequest {

    @Valid
    private MoedaRequest moeda;

    @Digits(integer = 10, fraction = 2, message = "O campo 'preco' deverá conter no máximo 10 números na parte inteira e no máximo 2 números na parte fracional")
    private BigDecimal preco;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataFim;

}
