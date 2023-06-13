package com.sevenine.usuario.services;

import com.sevenine.usuario.enumerator.StatusCadastro;

public interface BuscaStatusCadastroService {
    StatusCadastro validar(String email, String modulo);
}
