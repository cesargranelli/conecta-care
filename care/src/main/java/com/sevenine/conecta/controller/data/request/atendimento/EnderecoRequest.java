package com.sevenine.conecta.controller.data.request.atendimento;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EnderecoRequest {

    private Long id;

    @NotBlank(message = "O campo logradouro do objeto 'endereco' é obrigatório")
    private String logradouro;

    @NotBlank(message = "O campo numero do objeto 'endereco' é obrigatório")
    private String numero;

    private String complemento;

    @NotBlank(message = "O campo bairro do objeto 'endereco' é obrigatório")
    private String bairro;

    @NotBlank(message = "O campo cidade do objeto 'endereco' é obrigatório")
    private String cidade;

    @NotBlank(message = "O campo cep do objeto 'endereco' é obrigatório")
    private String cep;

    @NotNull(message = "O objeto estado do objeto 'endereco' é obrigatório")
    private EstadoRequest estado;

    //    @Valid
//    @NotNull(message = "O objeto pais do objeto 'endereco' é obrigatório")
    private PaisRequest pais;

}
