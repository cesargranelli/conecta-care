package com.sevenine.conecta.mapper.consulta.impl;

import com.sevenine.conecta.controller.data.response.CategoriaCnhResponse;
import com.sevenine.conecta.controller.data.response.ComplementoResponse;
import com.sevenine.conecta.mapper.consulta.ConsultaComplementoMapper;
import com.sevenine.conecta.repository.data.CategoriaCnh;
import com.sevenine.conecta.repository.data.Complemento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaComplementoMapperImpl implements ConsultaComplementoMapper {

    @Override
    public ComplementoResponse fromEntityData(Complemento complemento) {
        if ( complemento == null ) {
            return null;
        }

        ComplementoResponse complementoResponse = new ComplementoResponse();

        complementoResponse.setId( complemento.getId() );
        complementoResponse.setTituloEleitoral( complemento.getTituloEleitoral() );
        complementoResponse.setZonaEleitoral( complemento.getZonaEleitoral() );
        complementoResponse.setSecaoEleitoral( complemento.getSecaoEleitoral() );
        complementoResponse.setNumeroHabilitacao( complemento.getNumeroHabilitacao() );
        complementoResponse.setCategoriaCnh( categoriaCnhToCategoriaCnhResponse( complemento.getCategoriaCnh() ) );
        complementoResponse.setDataValidadeHabilitacao( complemento.getDataValidadeHabilitacao() );
        complementoResponse.setNumeroReservista( complemento.getNumeroReservista() );
        complementoResponse.setNomeMae( complemento.getNomeMae() );
        complementoResponse.setProfissaoMae( complemento.getProfissaoMae() );
        complementoResponse.setNomePai( complemento.getNomePai() );
        complementoResponse.setProfissaoPai( complemento.getProfissaoPai() );
        complementoResponse.setNomeConjuge( complemento.getNomeConjuge() );
        complementoResponse.setProfissaoConjuge( complemento.getProfissaoConjuge() );
        complementoResponse.setFotoCnhFrente( complemento.getFotoCnhFrente() );
        complementoResponse.setFotoCnhVerso( complemento.getFotoCnhVerso() );
        complementoResponse.setCarteiraVacinacao( complemento.isCarteiraVacinacao() );

        return complementoResponse;
    }

    protected CategoriaCnhResponse categoriaCnhToCategoriaCnhResponse(CategoriaCnh categoriaCnh) {
        if ( categoriaCnh == null ) {
            return null;
        }

        CategoriaCnhResponse categoriaCnhResponse = new CategoriaCnhResponse();

        categoriaCnhResponse.setId( categoriaCnh.getId() );
        categoriaCnhResponse.setSigla( categoriaCnh.getSigla() );

        return categoriaCnhResponse;
    }
}
