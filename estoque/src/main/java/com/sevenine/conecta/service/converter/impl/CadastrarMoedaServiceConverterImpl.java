package com.sevenine.conecta.services.converter.impl;

import com.sevenine.conecta.controllers.data.request.MoedaRequest;
import com.sevenine.conecta.repository.data.MoedaData;
import com.sevenine.conecta.services.converter.CadastrarMoedaServiceConverter;
import org.springframework.stereotype.Component;

@Component
public class CadastrarMoedaServiceConverterImpl implements CadastrarMoedaServiceConverter {

    @Override
    public MoedaData toJpaData(MoedaRequest request) {

        MoedaData moedaData = new MoedaData();
        moedaData.setId(request.getId());
        moedaData.setDescricao(request.getDescricao());

        return moedaData;

    }
}
