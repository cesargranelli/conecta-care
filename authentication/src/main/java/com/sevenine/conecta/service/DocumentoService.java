package com.sevenine.conecta.services;

import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.controllers.data.response.ConsultaUsuarioResponse;
import com.sevenine.conecta.controllers.data.response.ValidationResponse;

public interface DocumentoService {
    ConsultaUsuarioResponse consulta(long idDocumento);

    ValidationResponse atualizarStatus(long idDocumento, StatusCadastro statusCadastro);
}
