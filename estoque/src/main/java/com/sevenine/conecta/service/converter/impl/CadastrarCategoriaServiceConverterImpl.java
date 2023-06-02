package com.sevenine.conecta.services.converter.impl;

import com.sevenine.conecta.adapter.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.CategoriaData;
import com.sevenine.conecta.services.converter.CadastrarCategoriaServiceConverter;
import org.springframework.stereotype.Component;

@Component
public class CadastrarCategoriaServiceConverterImpl implements CadastrarCategoriaServiceConverter {

    @Override
    public CategoriaData toJpaData(CadastroMaterialRequest request) {

        CategoriaData categoriaData = new CategoriaData();
        categoriaData.setDescricao(request.getMaterial().getCategoria().getDescricao());
        categoriaData.setId(request.getMaterial().getCategoria().getId());

        return categoriaData;

    }

}
