package com.sevenine.usuario.usecase;

import com.sevenine.usuario.entity.ValidacaoUsuario;
import com.sevenine.usuario.adapter.controller.data.response.ValidationResponse;

public interface ValidaUsuarioUseCase {
    ValidationResponse executar(ValidacaoUsuario validacaoUsuario);
}
