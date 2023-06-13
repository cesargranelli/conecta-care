package com.sevenine.usuario.services;

import com.sevenine.usuario.repository.data.Usuario;

public interface ConsultaUsuarioService {
    Usuario buscarUsuario(String email);
}
