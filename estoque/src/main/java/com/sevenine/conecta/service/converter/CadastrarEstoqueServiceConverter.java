package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.EstoqueData;

public interface CadastrarEstoqueServiceConverter {

    EstoqueData toJpaData(CadastroMaterialRequest request);

}
