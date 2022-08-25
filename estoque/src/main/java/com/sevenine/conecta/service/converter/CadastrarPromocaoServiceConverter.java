package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.controllers.data.request.PromocaoRequest;
import com.sevenine.conecta.repository.data.PromocaoData;

public interface CadastrarPromocaoServiceConverter {

    PromocaoData toJpaData(PromocaoRequest request);

}
