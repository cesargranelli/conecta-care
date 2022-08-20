package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.UnidadesMedidaData;

public interface CadastrarUnidadeMedidaServiceConverter {

    UnidadesMedidaData toJpaData(CadastroMaterialRequest request);

}
