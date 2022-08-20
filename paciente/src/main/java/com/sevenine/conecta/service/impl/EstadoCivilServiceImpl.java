package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.http.resource.EstadoCivilResource;
import com.sevenine.conecta.repository.EstadoCivilRepository;
import com.sevenine.conecta.repository.conveter.EstadoCivilConverter;
import com.sevenine.conecta.service.EstadoCivilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstadoCivilServiceImpl implements EstadoCivilService {

    private final EstadoCivilRepository estadoCivilRepository;

    private final EstadoCivilConverter estadoCivilConverter;

    @Override
    public List<EstadoCivilResource> list() {
        return estadoCivilRepository
                .findAll()
                .stream()
                .map(estadoCivilConverter::toResource)
                .collect(Collectors.toList());
    }

}
