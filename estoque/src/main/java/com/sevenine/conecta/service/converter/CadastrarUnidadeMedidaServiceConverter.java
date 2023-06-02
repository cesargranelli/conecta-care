package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.adapter.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.UnidadesMedidaData;

public interface CadastrarUnidadeMedidaServiceConverter {

    UnidadesMedidaData toJpaData(CadastroMaterialRequest request);

}
