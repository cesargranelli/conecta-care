package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.controllers.data.request.MoedaRequest;
import com.sevenine.conecta.repository.data.MoedaData;

public interface CadastrarMoedaServiceConverter {

    MoedaData toJpaData(MoedaRequest request);

}
