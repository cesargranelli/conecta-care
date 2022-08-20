package com.sevenine.conecta.http.resource;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class EstadoCivilResource {

    private Long id;

    private String tipo;

    private String descricao;

}
