package com.sevenine.usuario.usecase;

import com.sevenine.usuario.adapter.controller.data.request.CadastroUsuarioRequest;

import java.sql.SQLException;

public interface CadastraUsuarioUseCase {
    String executar(CadastroUsuarioRequest request) throws SQLException;
}
