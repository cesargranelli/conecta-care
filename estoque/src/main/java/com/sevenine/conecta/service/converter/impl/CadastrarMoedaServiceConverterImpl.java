package com.sevenine.conecta.service.converter.impl;

import com.sevenine.conecta.controller.data.request.MoedaRequest;
import com.sevenine.conecta.repository.data.MoedaData;
import com.sevenine.conecta.service.converter.CadastrarMoedaServiceConverter;
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
