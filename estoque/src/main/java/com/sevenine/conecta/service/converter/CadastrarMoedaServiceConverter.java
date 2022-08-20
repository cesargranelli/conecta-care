package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.MoedaRequest;
import com.sevenine.conecta.repository.data.MoedaData;

public interface CadastrarMoedaServiceConverter {

    MoedaData toJpaData(MoedaRequest request);

}
