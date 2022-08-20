package com.sevenine.conecta.usecase;

import com.sevenine.conecta.service.data.response.PlantonistaResponse;

import java.util.List;

public interface ConsultaListaPlantonistaUseCase {
    List<PlantonistaResponse> executar(List<Long> plantonistasIds);
}
