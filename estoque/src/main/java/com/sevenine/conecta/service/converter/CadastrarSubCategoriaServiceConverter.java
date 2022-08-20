package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.SubCategoriaData;

public interface CadastrarSubCategoriaServiceConverter {

    SubCategoriaData toJpaData(CadastroMaterialRequest request);

}
