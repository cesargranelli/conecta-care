package com.sevenine.conecta.controller.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnderecoRequest {
    private Long id;
    private EstadoRequest estado;
    private PaisRequest pais;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String comprovante;
    private Long idHomeCare;
}
