package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.adapter.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.LocacaoData;

public interface CadastrarLocacaoServiceConverter {

    LocacaoData toJpaData(CadastroMaterialRequest request);

}
