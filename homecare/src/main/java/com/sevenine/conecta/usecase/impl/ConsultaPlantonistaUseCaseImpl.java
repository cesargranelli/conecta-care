package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.services.ConsultaPlantonistaService;
import com.sevenine.conecta.services.data.response.PlantonistaResponse;
import com.sevenine.conecta.usecase.ConsultaPlantonistaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConsultaPlantonistaUseCaseImpl implements ConsultaPlantonistaUseCase {

    private final ConsultaPlantonistaService service;

    @Override
    public PlantonistaResponse executar(Long plantonistaId, Long homeCareId) {
        return service.consultar(plantonistaId, homeCareId);
    }

}
