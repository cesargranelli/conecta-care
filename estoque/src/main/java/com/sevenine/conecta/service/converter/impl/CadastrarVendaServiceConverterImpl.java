package com.sevenine.conecta.services.converter.impl;

import com.sevenine.conecta.adapter.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.MoedaData;
import com.sevenine.conecta.repository.data.PromocaoData;
import com.sevenine.conecta.repository.data.VendaData;
import com.sevenine.conecta.services.converter.CadastrarMoedaServiceConverter;
import com.sevenine.conecta.services.converter.CadastrarPromocaoServiceConverter;
import com.sevenine.conecta.services.converter.CadastrarVendaServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarVendaServiceConverterImpl implements CadastrarVendaServiceConverter {

    private final CadastrarMoedaServiceConverter moedaConverter;
    private final CadastrarPromocaoServiceConverter promocaoConverter;

    @Override
    public VendaData toJpaData(CadastroMaterialRequest request) {

        VendaData vendaData = new VendaData();
        vendaData.setPreco(request.getVenda().getPreco());

        PromocaoData promocaoData = promocaoConverter.toJpaData(request.getVenda().getPromocao());
        vendaData.setPromocao(promocaoData);

        MoedaData moedaData = moedaConverter.toJpaData(request.getVenda().getMoeda());
        vendaData.setMoeda(moedaData);

        return vendaData;

    }

}
