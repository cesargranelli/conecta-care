package com.sevenine.conecta.service;

import com.sevenine.conecta.service.data.response.PlantonistaResponse;
import org.springframework.stereotype.Service;

@Service
public interface ConsultaPlantonistaService {
    PlantonistaResponse consultar(Long plantonistaId, Long homeCareId);
}
