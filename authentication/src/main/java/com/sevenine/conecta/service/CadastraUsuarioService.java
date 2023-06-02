package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.request.CadastroUsuarioRequest;
import com.sevenine.conecta.repository.data.Usuario;

import java.sql.SQLIntegrityConstraintViolationException;

public interface CadastraUsuarioService {
    Usuario cadastrar(CadastroUsuarioRequest request) throws SQLIntegrityConstraintViolationException;
}
