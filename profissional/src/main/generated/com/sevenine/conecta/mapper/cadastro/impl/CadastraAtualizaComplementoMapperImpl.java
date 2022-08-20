package com.sevenine.conecta.mapper.cadastro.impl;

import com.sevenine.conecta.controller.data.request.ComplementoRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaComplementoResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaComplementoMapper;
import com.sevenine.conecta.repository.data.Complemento;
import com.sevenine.conecta.repository.data.Profissional;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class CadastraAtualizaComplementoMapperImpl implements CadastraAtualizaComplementoMapper {

    @Override
    public Complemento toEntityData(ComplementoRequest request) {
        if ( request == null ) {
            return null;
        }

        Complemento complemento = new Complemento();

        complemento.setProfissional( complementoRequestToProfissional( request ) );
        complemento.setFotoCnhFrente( request.getFotoCNHFrente() );
        complemento.setFotoCnhVerso( request.getFotoCNHVerso() );
        complemento.setId( request.getId() );
        complemento.setTituloEleitoral( request.getTituloEleitoral() );
        complemento.setZonaEleitoral( request.getZonaEleitoral() );
        complemento.setSecaoEleitoral( request.getSecaoEleitoral() );
        complemento.setNumeroHabilitacao( request.getNumeroHabilitacao() );
        complemento.setDataValidadeHabilitacao( request.getDataValidadeHabilitacao() );
        complemento.setNumeroReservista( request.getNumeroReservista() );
        complemento.setNomeMae( request.getNomeMae() );
        complemento.setProfissaoMae( request.getProfissaoMae() );
        complemento.setNomePai( request.getNomePai() );
        complemento.setProfissaoPai( request.getProfissaoPai() );
        complemento.setNomeConjuge( request.getNomeConjuge() );
        complemento.setProfissaoConjuge( request.getProfissaoConjuge() );
        complemento.setCarteiraVacinacao( request.isCarteiraVacinacao() );

        return complemento;
    }

    @Override
    public CadastraAtualizaComplementoResponse fromEntityData(Complemento complemento) {
        if ( complemento == null ) {
            return null;
        }

        CadastraAtualizaComplementoResponse cadastraAtualizaComplementoResponse = new CadastraAtualizaComplementoResponse();

        cadastraAtualizaComplementoResponse.setProfissionalId( complementoProfissionalId( complemento ) );

        return cadastraAtualizaComplementoResponse;
    }

    protected Profissional complementoRequestToProfissional(ComplementoRequest complementoRequest) {
        if ( complementoRequest == null ) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setId( complementoRequest.getProprietarioId() );

        return profissional;
    }

    private Long complementoProfissionalId(Complemento complemento) {
        if ( complemento == null ) {
            return null;
        }
        Profissional profissional = complemento.getProfissional();
        if ( profissional == null ) {
            return null;
        }
        Long id = profissional.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
