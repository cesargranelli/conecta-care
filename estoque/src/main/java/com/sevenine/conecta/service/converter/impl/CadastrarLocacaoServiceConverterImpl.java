package com.sevenine.conecta.service.converter.impl;

import com.sevenine.conecta.controller.data.request.CadastroMaterialRequest;
import com.sevenine.conecta.repository.data.LocacaoData;
import com.sevenine.conecta.repository.data.MoedaData;
import com.sevenine.conecta.repository.data.PromocaoData;
import com.sevenine.conecta.service.converter.CadastrarLocacaoServiceConverter;
import com.sevenine.conecta.service.converter.CadastrarMoedaServiceConverter;
import com.sevenine.conecta.service.converter.CadastrarPromocaoServiceConverter;
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