package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.services.ConsultaListaPlantonistaService;
import com.sevenine.conecta.services.data.response.PlantonistaResponse;
import com.sevenine.conecta.usecase.ConsultaListaPlantonistaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ConsultaListaPlantonistaUseCaseImpl implements ConsultaListaPlantonistaUseCase {

    private final ConsultaListaPlantonistaService service;

    @Override
    public List<PlantonistaResponse> executar(List<Long> plantonistasIds) {
        return service.consultar(plantonistasIds);
    }

}
