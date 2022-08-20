package com.sevenine.conecta.usecase;

import com.sevenine.conecta.service.data.response.PlantonistaResponse;

public interface ConsultaPlantonistaUseCase {
    PlantonistaResponse executar(Long plantonistaId, Long homeCareId);
}
