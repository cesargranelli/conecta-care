package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.controllers.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.SubCategoriaData;

public interface CadastrarSubCategoriaServiceConverter {

    SubCategoriaData toJpaData(CadastroMaterialRequest request);

}
