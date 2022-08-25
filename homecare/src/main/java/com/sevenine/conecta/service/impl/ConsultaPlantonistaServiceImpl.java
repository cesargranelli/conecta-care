package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.exception.InformacaoNaoLocalizadaException;
import com.sevenine.conecta.mapper.ConsultaPlantonistaMapper;
import com.sevenine.conecta.repository.PlantonistaRepository;
import com.sevenine.conecta.repository.data.Plantonista;
import com.sevenine.conecta.services.ConsultaPlantonistaService;
import com.sevenine.conecta.services.data.response.PlantonistaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaPlantonistaServiceImpl implements ConsultaPlantonistaService {

    private final PlantonistaRepository repository;

    private final ConsultaPlantonistaMapper mapper;

    @Override
    public PlantonistaResponse consultar(Long plantonistaId, Long homeCareId) {
        Optional<Plantonista> optional = repository.findByIdAndHomeCareId(plantonistaId, homeCareId);
        return mapper.fromEntityData(optional.orElseThrow(() -> new InformacaoNaoLocalizadaException(null, null)));
    }

}
