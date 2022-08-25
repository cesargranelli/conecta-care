package com.sevenine.conecta.services;

import com.sevenine.conecta.enumerator.StatusCadastro;

public interface BuscaStatusCadastroService {
    StatusCadastro validar(String email, String modulo);
}
