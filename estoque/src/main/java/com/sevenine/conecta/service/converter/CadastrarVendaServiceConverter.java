package com.sevenine.conecta.service.converter;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.VendaData;

public interface CadastrarVendaServiceConverter {

    VendaData toJpaData(CadastroMaterialRequest request);

}
