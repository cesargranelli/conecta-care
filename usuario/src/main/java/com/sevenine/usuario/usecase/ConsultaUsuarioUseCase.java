package com.sevenine.usuario.usecase;

import com.sevenine.usuario.entity.ConsultaUsuario;
import com.sevenine.usuario.adapter.controller.data.response.ConsultaUsuarioResponse;

public interface ConsultaUsuarioUseCase {
    ConsultaUsuarioResponse executar(ConsultaUsuario consultaUsuario);
}
