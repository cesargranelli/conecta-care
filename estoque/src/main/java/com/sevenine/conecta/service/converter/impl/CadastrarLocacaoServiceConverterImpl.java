package com.sevenine.conecta.services.converter.impl;

import com.sevenine.conecta.adapter.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.LocacaoData;
import com.sevenine.conecta.repository.data.MoedaData;
import com.sevenine.conecta.repository.data.PromocaoData;
import com.sevenine.conecta.services.converter.CadastrarLocacaoServiceConverter;
import com.sevenine.conecta.services.converter.CadastrarMoedaServiceConverter;
import com.sevenine.conecta.services.converter.CadastrarPromocaoServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarLocacaoServiceConverterImpl implements CadastrarLocacaoServiceConverter {

    private final CadastrarMoedaServiceConverter moedaConverter;
    private final CadastrarPromocaoServiceConverter promocaoConverter;

    @Override
    public LocacaoData toJpaData(CadastroMaterialRequest request) {

        LocacaoData locacaoData = new LocacaoData();
        locacaoData.setPreco(request.getLocacao().getPreco());

        PromocaoData promocaoData = promocaoConverter.toJpaData(request.getLocacao().getPromocao());
        locacaoData.setPromocao(promocaoData);

        MoedaData moedaData = moedaConverter.toJpaData(request.getLocacao().getMoeda());
        locacaoData.setMoeda(moedaData);

        return locacaoData;
    }
}