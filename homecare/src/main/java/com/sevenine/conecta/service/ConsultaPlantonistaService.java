package com.sevenine.conecta.services;

import com.sevenine.conecta.services.data.response.PlantonistaResponse;
import org.springframework.stereotype.Service;

@Service
public interface ConsultaPlantonistaService {
    PlantonistaResponse consultar(Long plantonistaId, Long homeCareId);
}
