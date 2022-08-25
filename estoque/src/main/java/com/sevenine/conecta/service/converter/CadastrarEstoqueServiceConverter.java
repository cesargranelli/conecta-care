package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.controllers.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.EstoqueData;

public interface CadastrarEstoqueServiceConverter {

    EstoqueData toJpaData(CadastroMaterialRequest request);

}
