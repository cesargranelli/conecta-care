package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.exception.InformacaoNaoLocalizadaException;
import com.sevenine.conecta.mapper.ConsultaListaPlantonistaMapper;
import com.sevenine.conecta.repository.PlantonistaRepository;
import com.sevenine.conecta.repository.data.Plantonista;
import com.sevenine.conecta.services.ConsultaListaPlantonistaService;
import com.sevenine.conecta.services.data.response.PlantonistaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsultaListaPlantonistaServiceImpl implements ConsultaListaPlantonistaService {

    private final ConsultaListaPlantonistaMapper mapper;

    private final PlantonistaRepository repository;

    @Override
    public List<PlantonistaResponse> consultar(List<Long> plantonistasIds) {
        Optional<List<Plantonista>> optional = repository.findByIdIn(plantonistasIds);

        return mapper.fromEntityDataList(optional.orElseThrow(() -> new InformacaoNaoLocalizadaException(
                null, HttpStatus.NO_CONTENT
        )));
    }

}
