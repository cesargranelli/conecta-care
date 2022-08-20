package com.sevenine.conecta.service;

import com.sevenine.conecta.repository.data.Estado;

public interface ConsultaEstadoService {
    Estado consultar(Long estadoId);
}
