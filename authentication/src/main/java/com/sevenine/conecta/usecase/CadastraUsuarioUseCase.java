package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.request.CadastroUsuarioRequest;

import java.sql.SQLException;

public interface CadastraUsuarioUseCase {
    String executar(CadastroUsuarioRequest request) throws SQLException;
}
