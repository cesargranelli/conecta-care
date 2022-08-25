package com.sevenine.conecta.services;

import com.sevenine.conecta.repository.data.Usuario;

public interface ConsultaUsuarioService {
    Usuario buscarUsuario(String email);
}
