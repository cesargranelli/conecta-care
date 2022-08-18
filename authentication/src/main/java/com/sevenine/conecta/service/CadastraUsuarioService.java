package com.sevenine.conecta.service;

import com.sevenine.conecta.http.data.request.CadastroUsuarioRequest;
import com.sevenine.conecta.repository.data.Usuario;

import java.sql.SQLIntegrityConstraintViolationException;

public interface CadastraUsuarioService {
    Usuario cadastrar(CadastroUsuarioRequest request) throws SQLIntegrityConstraintViolationException;
}
