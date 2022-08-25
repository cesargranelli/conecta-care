package com.sevenine.conecta.services;

import com.sevenine.conecta.repository.data.Estado;

public interface ConsultaEstadoService {
    Estado consultar(Long estadoId);
}
