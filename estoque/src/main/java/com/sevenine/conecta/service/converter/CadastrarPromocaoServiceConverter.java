package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.PromocaoRequest;
import com.sevenine.conecta.repository.data.PromocaoData;

public interface CadastrarPromocaoServiceConverter {

    PromocaoData toJpaData(PromocaoRequest request);

}
