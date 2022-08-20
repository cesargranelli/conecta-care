package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.CategoriaData;

public interface CadastrarCategoriaServiceConverter {

    CategoriaData toJpaData(CadastroMaterialRequest request);

}
