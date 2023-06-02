package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.adapter.GeneroAdapter;
import com.sevenine.conecta.adapter.controller.data.response.ConsultaGeneroResponse;
import com.sevenine.conecta.mapper.GeneroMapper;
import com.sevenine.conecta.services.DominioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GeneroServiceImpl implements DominioService<Object, List<ConsultaGeneroResponse>> {

//    private final GeneroMapper mapper;

//    private final GeneroRepository repository;

    private final GeneroAdapter adapter;

    public List<ConsultaGeneroResponse> executa() {
        return GeneroMapper.INSTANCE.toResponse(adapter.listarTodos());
//        return mapper.fromEntityData(repository.findAll());
    }

    @Override
    public List<ConsultaGeneroResponse> executar(Object... objects) {
        return GeneroMapper.INSTANCE.toResponse(adapter.listarTodos());
    }
}
