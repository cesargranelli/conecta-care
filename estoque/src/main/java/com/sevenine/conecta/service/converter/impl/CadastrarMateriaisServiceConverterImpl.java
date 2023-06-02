package com.sevenine.conecta.services.converter.impl;

import com.sevenine.conecta.adapter.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.*;
import com.sevenine.conecta.services.converter.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarMateriaisServiceConverterImpl implements CadastrarMateriaisServiceConverter {

    private final CadastrarSubCategoriaServiceConverter subCategoriaConverter;
    private final CadastrarCategoriaServiceConverter categoriaConverter;
    private final CadastrarVendaServiceConverter vendaConverter;
    private final CadastrarLocacaoServiceConverter locacaoConverter;

    @Override
    public MaterialData toJpaData(CadastroMaterialRequest request) {

        MaterialData materialData = new MaterialData();
        materialData.setNome(request.getMaterial().getNome());
        materialData.setDescricao(request.getMaterial().getDescricao());
        materialData.setFoto(request.getMaterial().getFoto());
        materialData.setCodigoBarras(request.getMaterial().getCodigoBarras());

        CategoriaData categoriaData = categoriaConverter.toJpaData(request);
        materialData.setCategoria(categoriaData);

        SubCategoriaData subCategoriaData = subCategoriaConverter.toJpaData(request);
        materialData.setSubCategoria(subCategoriaData);

        VendaData vendaData = vendaConverter.toJpaData(request);
        materialData.setVenda(vendaData);

        LocacaoData locacaoData = locacaoConverter.toJpaData(request);
        materialData.setLocacao(locacaoData);

        return materialData;

    }

}
