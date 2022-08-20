package com.sevenine.conecta.service.converter.impl;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.EstoqueData;
import com.sevenine.conecta.repository.data.MaterialData;
import com.sevenine.conecta.repository.data.UnidadesMedidaData;
import com.sevenine.conecta.service.converter.CadastrarEstoqueServiceConverter;
import com.sevenine.conecta.service.converter.CadastrarMateriaisServiceConverter;
import com.sevenine.conecta.service.converter.CadastrarUnidadeMedidaServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarEstoqueServiceConverterImpl implements CadastrarEstoqueServiceConverter {

    private final CadastrarUnidadeMedidaServiceConverter unidadeMedidaConverter;
    private final CadastrarMateriaisServiceConverter materialConverter;

    @Override
    public EstoqueData toJpaData(CadastroMaterialRequest request) {

        EstoqueData estoqueData = new EstoqueData();
        estoqueData.setDataUltimaCompra(request.getEstoque().getDataUltimaCompra());
        estoqueData.setQuantidade(request.getEstoque().getQuantidade());

        MaterialData materialData = materialConverter.toJpaData(request);
        estoqueData.setMaterial(materialData);

        UnidadesMedidaData unidadesMedidaData = unidadeMedidaConverter.toJpaData(request);
        estoqueData.setUnidadeMedida(unidadesMedidaData);

        return estoqueData;

    }

}
