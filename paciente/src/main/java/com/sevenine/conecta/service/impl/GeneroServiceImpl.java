package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.resource.GeneroResource;
import com.sevenine.conecta.repository.GeneroRepository;
import com.sevenine.conecta.repository.conveter.GeneroConverter;
import com.sevenine.conecta.services.GeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepository;

    private final GeneroConverter generoConverter;

    @Override
    public List<GeneroResource> list() {
        return generoRepository
                .findAll()
                .stream()
                .map(generoConverter::toResource)
                .collect(Collectors.toList());
    }

}
