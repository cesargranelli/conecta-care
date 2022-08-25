package com.sevenine.conecta.services;

import com.sevenine.conecta.repository.data.Transporte;

public interface ConsultaTransporteService {
    Transporte consultar(Long transporteId);
}
