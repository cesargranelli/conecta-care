package com.sevenine.conecta.usecase;

import com.sevenine.conecta.services.data.response.PlantonistaResponse;

public interface ConsultaPlantonistaUseCase {
    PlantonistaResponse executar(Long plantonistaId, Long homeCareId);
}
