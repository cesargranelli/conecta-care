package com.sevenine.conecta.usecase;

import com.sevenine.conecta.entity.ValidacaoUsuario;
import com.sevenine.conecta.controllers.data.response.ValidationResponse;

public interface ValidaUsuarioUseCase {
    ValidationResponse executar(ValidacaoUsuario validacaoUsuario);
}
