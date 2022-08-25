package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.PlantonistaResponse;

import java.util.List;

public interface ConsultaListaPlantonistaService {
    List<PlantonistaResponse> consultar(List<Long> plantonistasIds);
}
