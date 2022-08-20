package com.sevenine.conecta.http.resource;

import com.sevenine.conecta.repository.entity.EstadoEntity;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class EnderecoResource {

    private Long idPaciente;

    private Long id;

    private String cep;

    private String logradouro;

    private Integer numero;

    private String bairro;

    private String cidade;

    private String complemento;

    private String fotoComprovante;

    private EstadoEntity estado;

}
