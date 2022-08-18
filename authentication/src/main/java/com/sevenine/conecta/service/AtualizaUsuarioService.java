package com.sevenine.conecta.service;

import com.sevenine.conecta.http.data.request.CadastroUsuarioRequest;
import com.sevenine.conecta.repository.data.Usuario;

public interface AtualizaUsuarioService {
    Usuario atualizar(Usuario usuario, CadastroUsuarioRequest request);
}
