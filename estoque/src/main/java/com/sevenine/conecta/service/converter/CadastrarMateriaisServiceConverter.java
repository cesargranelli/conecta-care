package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.controllers.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.MaterialData;

public interface CadastrarMateriaisServiceConverter {

    MaterialData toJpaData(CadastroMaterialRequest request);

}
