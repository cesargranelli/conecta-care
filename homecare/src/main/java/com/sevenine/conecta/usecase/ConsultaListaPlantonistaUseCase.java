package com.sevenine.conecta.usecase;

import com.sevenine.conecta.services.data.response.PlantonistaResponse;

import java.util.List;

public interface ConsultaListaPlantonistaUseCase {
    List<PlantonistaResponse> executar(List<Long> plantonistasIds);
}
