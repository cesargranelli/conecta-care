package com.sevenine.conecta.adapter.controller.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResponse {
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String comprovante;
    private EstadoResponse estado;
    private PaisResponse pais;
}
