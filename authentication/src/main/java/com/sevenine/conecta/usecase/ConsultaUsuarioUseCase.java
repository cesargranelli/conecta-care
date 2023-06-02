package com.sevenine.conecta.usecase;

import com.sevenine.conecta.entity.ConsultaUsuario;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaUsuarioResponse;

public interface ConsultaUsuarioUseCase {
    ConsultaUsuarioResponse executar(ConsultaUsuario consultaUsuario);
}
