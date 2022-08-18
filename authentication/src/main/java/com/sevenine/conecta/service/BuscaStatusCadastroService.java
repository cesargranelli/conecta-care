package com.sevenine.conecta.service;

import com.sevenine.conecta.enumerator.StatusCadastro;

public interface BuscaStatusCadastroService {
    StatusCadastro validar(String email, String modulo);
}
