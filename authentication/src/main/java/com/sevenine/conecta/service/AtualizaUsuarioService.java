package com.sevenine.conecta.services;

import com.sevenine.conecta.controllers.data.request.CadastroUsuarioRequest;
import com.sevenine.conecta.repository.data.Usuario;

public interface AtualizaUsuarioService {
    Usuario atualizar(Usuario usuario, CadastroUsuarioRequest request);
}
