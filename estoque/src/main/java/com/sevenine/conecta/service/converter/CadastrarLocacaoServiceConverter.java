package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.LocacaoData;

public interface CadastrarLocacaoServiceConverter {

    LocacaoData toJpaData(CadastroMaterialRequest request);

}
