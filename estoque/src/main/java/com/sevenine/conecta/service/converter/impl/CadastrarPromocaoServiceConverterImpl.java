package com.sevenine.conecta.service.converter.impl;

import com.sevenine.conecta.controller.data.request.PromocaoRequest;
import com.sevenine.conecta.repository.data.MoedaData;
import com.sevenine.conecta.repository.data.PromocaoData;
import com.sevenine.conecta.service.converter.CadastrarMoedaServiceConverter;
import com.sevenine.conecta.service.converter.CadastrarPromocaoServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarPromocaoServiceConverterImpl implements CadastrarPromocaoServiceConverter {

    private final CadastrarMoedaServiceConverter converter;

    @Override
    public PromocaoData toJpaData(PromocaoRequest request) {

        PromocaoData promocaoData = new PromocaoData();
        promocaoData.setDataFim(request.getDataFim());
        promocaoData.setDataInicio(request.getDataInicio());
        promocaoData.setPreco(request.getPreco());

        MoedaData moedaData = converter.toJpaData(request.getMoeda());
        promocaoData.setMoeda(moedaData);

        return promocaoData;
    }

}
