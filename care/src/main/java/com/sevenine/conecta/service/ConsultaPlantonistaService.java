package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.PlantonistaResponse;

public interface ConsultaPlantonistaService {
    PlantonistaResponse consultar(Long homeCareId, Long plantonistaId);
}
