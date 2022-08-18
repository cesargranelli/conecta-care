package com.sevenine.conecta.usecase;

import com.sevenine.conecta.entity.ConsultaUsuario;
import com.sevenine.conecta.http.data.response.ConsultaUsuarioResponse;

public interface ConsultaUsuarioUseCase {
    ConsultaUsuarioResponse executar(ConsultaUsuario consultaUsuario);
}
