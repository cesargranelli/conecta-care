package com.sevenine.usuario.services;

import com.sevenine.usuario.adapter.controller.data.request.CadastroUsuarioRequest;
import com.sevenine.usuario.repository.data.Usuario;

public interface AtualizaUsuarioService {
    Usuario atualizar(Usuario usuario, CadastroUsuarioRequest request);
}
