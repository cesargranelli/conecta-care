package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.MaterialData;

public interface CadastrarMateriaisServiceConverter {

    MaterialData toJpaData(CadastroMaterialRequest request);

}
