package com.sevenine.conecta.service;

import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.http.data.response.ConsultaUsuarioResponse;
import com.sevenine.conecta.http.data.response.ValidationResponse;

public interface DocumentoService {
    ConsultaUsuarioResponse consulta(long idDocumento);

    ValidationResponse atualizarStatus(long idDocumento, StatusCadastro statusCadastro);
}
