package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.config.properties.ExceptionMessageProperties;
import com.sevenine.conecta.adapter.controller.data.response.ListaProfissionalResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.mapper.ListaProfissionalMapper;
import com.sevenine.conecta.repository.ListaProfissionalRepository;
import com.sevenine.conecta.repository.data.ListaProfissional;
import com.sevenine.conecta.services.ListaProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListaProfissionalServiceImpl implements ListaProfissionalService {

    private final ExceptionMessageProperties properties;

    private final ListaProfissionalMapper mapper;

    private final ListaProfissionalRepository repository;

    @Override
    public List<ListaProfissionalResponse> listar(List<Long> profissionaisIds) {
        List<ListaProfissional> profissionalList =
                repository.findByIdIn(profissionaisIds).orElseThrow(() -> new InformacaoNaoEncontradaException(
                        properties.getProfissionalNaoEncontrado(), HttpStatus.NO_CONTENT));

        return mapper.fromEntityDataList(profissionalList);
    }

}
