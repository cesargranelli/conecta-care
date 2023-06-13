package com.sevenine.usuario.services;

import com.sevenine.usuario.enumerator.StatusCadastro;
import com.sevenine.usuario.adapter.controller.data.response.ConsultaUsuarioResponse;
import com.sevenine.usuario.adapter.controller.data.response.ValidationResponse;

public interface DocumentoService {
    ConsultaUsuarioResponse consulta(long idDocumento);

    ValidationResponse atualizarStatus(long idDocumento, StatusCadastro statusCadastro);
}
