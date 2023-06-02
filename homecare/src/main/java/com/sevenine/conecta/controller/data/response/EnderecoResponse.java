package com.sevenine.conecta.adapter.controller.data.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EnderecoResponse {
    private final Long id;
    private final EstadoResponse estado;
    private final PaisResponse pais;
    private final String logradouro;
    private final int numero;
    private final String complemento;
    private final String bairro;
    private final String cidade;
    private final String cep;
    private final String comprovante;
    private final Long idHomeCare;
}
