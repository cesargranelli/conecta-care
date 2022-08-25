package com.sevenine.conecta.services.converter;

import com.sevenine.conecta.controllers.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.VendaData;

public interface CadastrarVendaServiceConverter {

    VendaData toJpaData(CadastroMaterialRequest request);

}
