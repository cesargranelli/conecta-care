package com.sevenine.conecta.mapper.cadastro.impl;

import com.sevenine.conecta.controller.data.request.TelefoneRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaTelefoneResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaTelefoneMapper;
import com.sevenine.conecta.repository.data.Profissional;
import com.sevenine.conecta.repository.data.Telefone;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class CadastraAtualizaTelefoneMapperImpl implements CadastraAtualizaTelefoneMapper {

    @Override
    public Telefone toEntityData(TelefoneRequest request) {
        if ( request == null ) {
            return null;
        }

        Telefone telefone = new Telefone();

        telefone.setProfissional( telefoneRequestToProfissional( request ) );
        telefone.setTelefoneFixo( request.getTelefoneFixo() );
        telefone.setTelefoneRecado( request.getTelefoneRecado() );
        telefone.setCelularPrincipal( request.getCelularPrincipal() );
        telefone.setCelularSecundario( request.getCelularSecundario() );

        return telefone;
    }

    @Override
    public CadastraAtualizaTelefoneResponse fromEntityData(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }

        CadastraAtualizaTelefoneResponse cadastraAtualizaTelefoneResponse = new CadastraAtualizaTelefoneResponse();

        cadastraAtualizaTelefoneResponse.setProfissionalId( telefoneProfissionalId( telefone ) );

        return cadastraAtualizaTelefoneResponse;
    }

    @Override
    public void updateTelefone(TelefoneRequest request, Telefone telefone) {
        if ( request == null ) {
            return;
        }

        telefone.setTelefoneFixo( request.getTelefoneFixo() );
        telefone.setTelefoneRecado( request.getTelefoneRecado() );
        telefone.setCelularPrincipal( request.getCelularPrincipal() );
        telefone.setCelularSecundario( request.getCelularSecundario() );
    }

    protected Profissional telefoneRequestToProfissional(TelefoneRequest telefoneRequest) {
        if ( telefoneRequest == null ) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setId( telefoneRequest.getProprietarioId() );

        return profissional;
    }

    private Long telefoneProfissionalId(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }
        Profissional profissional = telefone.getProfissional();
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
