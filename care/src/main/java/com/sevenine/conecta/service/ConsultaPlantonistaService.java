package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.PlantonistaResponse;

public interface ConsultaPlantonistaService {
    PlantonistaResponse consultar(Long homeCareId, Long plantonistaId);
}
