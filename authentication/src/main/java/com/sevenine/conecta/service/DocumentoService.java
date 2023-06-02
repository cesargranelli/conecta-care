package com.sevenine.conecta.services;

import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaUsuarioResponse;
import com.sevenine.conecta.adapter.controller.data.response.ValidationResponse;

public interface DocumentoService {
    ConsultaUsuarioResponse consulta(long idDocumento);

    ValidationResponse atualizarStatus(long idDocumento, StatusCadastro statusCadastro);
}
