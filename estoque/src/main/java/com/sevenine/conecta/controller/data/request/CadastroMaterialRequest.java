package com.sevenine.conecta.adapter.controller.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
public class CadastroMaterialRequest {

    @Valid
    private MaterialRequest material;

    @Valid
    private EstoqueRequest estoque;

    @Valid
    private ComercioRequest locacao;

    @Valid
    private ComercioRequest venda;

}
