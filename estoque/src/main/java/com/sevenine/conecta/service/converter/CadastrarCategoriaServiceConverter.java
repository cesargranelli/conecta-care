package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.controllers.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.CategoriaData;

public interface CadastrarCategoriaServiceConverter {

    CategoriaData toJpaData(CadastroMaterialRequest request);

}
