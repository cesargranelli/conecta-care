package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.http.resource.EstadoResource;
import com.sevenine.conecta.repository.EstadoRepository;
import com.sevenine.conecta.repository.conveter.EstadoConverter;
import com.sevenine.conecta.service.EstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository estadoRepository;

    private final EstadoConverter estadoConverter;

    @Override
    public List<EstadoResource> list() {
        return estadoRepository
                .findAll()
                .stream()
                .map(estadoConverter::toResource)
                .collect(Collectors.toList());
    }

}
