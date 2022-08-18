package com.sevenine.conecta.http.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ConsultaUsuarioResponse {
    private long id;
    private String email;
    private String role;
    private String status;
}
