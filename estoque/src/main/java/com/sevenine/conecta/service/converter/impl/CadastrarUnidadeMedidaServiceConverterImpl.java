package com.sevenine.conecta.services.converter.impl;

import com.sevenine.conecta.adapter.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.UnidadesMedidaData;
import com.sevenine.conecta.services.converter.CadastrarUnidadeMedidaServiceConverter;
import org.springframework.stereotype.Component;

@Component
public class CadastrarUnidadeMedidaServiceConverterImpl implements CadastrarUnidadeMedidaServiceConverter {

    @Override
    public UnidadesMedidaData toJpaData(CadastroMaterialRequest request) {

        UnidadesMedidaData unidadesMedidaData = new UnidadesMedidaData();
        unidadesMedidaData.setId(request.getEstoque().getUnidadeMedida().getId());
        unidadesMedidaData.setDescricao(request.getEstoque().getUnidadeMedida().getDescricao());

        return unidadesMedidaData;

    }

}
