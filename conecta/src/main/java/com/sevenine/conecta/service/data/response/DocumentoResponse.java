package com.sevenine.conecta.service.data.response;

import com.sevenine.conecta.enumerator.Modulo;
import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.enumerator.TipoDocumento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoResponse {
    private Long id;
    private StatusCadastro status;
    private String documento;
    private TipoDocumento tipo;
    private Modulo modulo;
}
