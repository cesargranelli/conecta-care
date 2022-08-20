package com.sevenine.conecta.service.converter.impl;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.CategoriaData;
import com.sevenine.conecta.service.converter.CadastrarCategoriaServiceConverter;
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
