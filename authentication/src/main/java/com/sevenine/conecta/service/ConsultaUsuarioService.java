package com.sevenine.conecta.service;

import com.sevenine.conecta.repository.data.Usuario;

public interface ConsultaUsuarioService {
    Usuario buscarUsuario(String email);
}
