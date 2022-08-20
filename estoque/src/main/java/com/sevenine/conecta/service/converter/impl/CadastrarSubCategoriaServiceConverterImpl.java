package com.sevenine.conecta.service.converter.impl;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.SubCategoriaData;
import com.sevenine.conecta.service.converter.CadastrarSubCategoriaServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarSubCategoriaServiceConverterImpl implements CadastrarSubCategoriaServiceConverter {

    @Override
    public SubCategoriaData toJpaData(CadastroMaterialRequest request) {

        SubCategoriaData subCategoriaData = new SubCategoriaData();
        subCategoriaData.setDescricao(request.getMaterial().getSubCategoria().getDescricao());
        subCategoriaData.setId(request.getMaterial().getSubCategoria().getId());

        return subCategoriaData;

    }

}
