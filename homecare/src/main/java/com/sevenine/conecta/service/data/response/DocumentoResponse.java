package com.sevenine.conecta.services.data.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoResponse {
    private Long id;
    private String status;
    private String documento;
    private String tipo;
    private String modulo;
}
