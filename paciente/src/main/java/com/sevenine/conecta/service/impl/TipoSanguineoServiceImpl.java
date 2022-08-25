package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.resource.TipoSanguineoResource;
import com.sevenine.conecta.repository.TipoSanguineoRepository;
import com.sevenine.conecta.repository.conveter.TipoSanguineoConverter;
import com.sevenine.conecta.services.TipoSanguineoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipoSanguineoServiceImpl implements TipoSanguineoService {

    private final TipoSanguineoRepository tipoSanguineoRepository;

    private final TipoSanguineoConverter tipoSanguineoConverter;

    @Override
    public List<TipoSanguineoResource> list() {
        return tipoSanguineoRepository
                .findAll()
                .stream()
                .map(tipoSanguineoConverter::toResource)
                .collect(Collectors.toList());
    }

}
