package com.sevenine.conecta.controllers.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ComercioRequest {

    @Valid
    private MoedaRequest moeda;

    @Digits(integer = 10, fraction = 2, message = "O campo 'preco' deverá conter no máximo 10 números na parte inteira e no máximo 2 números na parte fracional")
    private BigDecimal preco;

    @Valid
    private PromocaoRequest promocao;


}
