package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.EstoqueRepository;
import com.sevenine.conecta.repository.data.EstoqueData;
import com.sevenine.conecta.service.CadastrarMateriaisService;
import com.sevenine.conecta.service.converter.CadastrarEstoqueServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarMateriaisServiceImpl implements CadastrarMateriaisService {

    private final CadastrarEstoqueServiceConverter converter;

    private final EstoqueRepository repository;

    @Override
    public void executar(CadastroMaterialRequest request) {

        EstoqueData estoqueData = converter.toJpaData(request);

        repository.save(estoqueData);

    }

}
