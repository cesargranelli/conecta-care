package com.sevenine.conecta.services;

import com.sevenine.conecta.adapter.controller.data.response.EstadoCivilResponse;

public interface EstadoCivilService {
    EstadoCivilResponse consultar(Long idEstadoCivil);
}
