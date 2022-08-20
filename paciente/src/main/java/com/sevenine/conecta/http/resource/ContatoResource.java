package com.sevenine.conecta.http.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class ContatoResource {

    private Long id;

    private String telefoneFixo;

    private String telefoneRecado;

    private String telefoneCelular;

    private String telefoneResponsavel;

    private String emailResponsavel;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long idPaciente;

}
