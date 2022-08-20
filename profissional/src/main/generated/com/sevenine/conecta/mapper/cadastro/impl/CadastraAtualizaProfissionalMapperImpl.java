package com.sevenine.conecta.mapper.cadastro.impl;

import com.sevenine.conecta.controller.data.request.ProfissionalRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaProfissionalResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaProfissionalMapper;
import com.sevenine.conecta.repository.data.EstadoCivil;
import com.sevenine.conecta.repository.data.Genero;
import com.sevenine.conecta.repository.data.Profissional;
import com.sevenine.conecta.repository.data.TipoEmpresa;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:51-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class CadastraAtualizaProfissionalMapperImpl implements CadastraAtualizaProfissionalMapper {

    @Override
    public Profissional toEntityData(ProfissionalRequest request) {
        if ( request == null ) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setGenero( profissionalRequestToGenero( request ) );
        profissional.setTipoEmpresa( profissionalRequestToTipoEmpresa( request ) );
        profissional.setEstadoCivil( profissionalRequestToEstadoCivil( request ) );
        profissional.setId( request.getId() );
        profissional.setCpf( request.getCpf() );
        profissional.setNome( request.getNome() );
        profissional.setSobrenome( request.getSobrenome() );
        profissional.setDataNascimento( request.getDataNascimento() );
        profissional.setRg( request.getRg() );
        profissional.setRgEmissor( request.getRgEmissor() );
        profissional.setRgDataEmissao( request.getRgDataEmissao() );
        profissional.setCnpj( request.getCnpj() );
        if ( request.getCtps() != null ) {
            profissional.setCtps( Long.parseLong( request.getCtps() ) );
        }
        profissional.setCtpsSerie( request.getCtpsSerie() );
        if ( request.getPis() != null ) {
            profissional.setPis( Long.parseLong( request.getPis() ) );
        }
        profissional.setFotoProfissional( request.getFotoProfissional() );
        profissional.setFotoRgFrente( request.getFotoRgFrente() );
        profissional.setFotoRgVerso( request.getFotoRgVerso() );
        profissional.setFotoAssinatura( request.getFotoAssinatura() );
        profissional.setFotoCtps( request.getFotoCtps() );
        profissional.setDisponivelParaAtendimento( request.getDisponivelParaAtendimento() );

        return profissional;
    }

    @Override
    public CadastraAtualizaProfissionalResponse fromEntityData(Profissional profissional) {
        if ( profissional == null ) {
            return null;
        }

        CadastraAtualizaProfissionalResponse cadastraAtualizaProfissionalResponse = new CadastraAtualizaProfissionalResponse();

        cadastraAtualizaProfissionalResponse.setProfissionalId( profissional.getId() );

        return cadastraAtualizaProfissionalResponse;
    }

    protected Genero profissionalRequestToGenero(ProfissionalRequest profissionalRequest) {
        if ( profissionalRequest == null ) {
            return null;
        }

        Genero genero = new Genero();

        genero.setId( profissionalRequest.getGenero() );

        return genero;
    }

    protected TipoEmpresa profissionalRequestToTipoEmpresa(ProfissionalRequest profissionalRequest) {
        if ( profissionalRequest == null ) {
            return null;
        }

        TipoEmpresa tipoEmpresa = new TipoEmpresa();

        tipoEmpresa.setId( profissionalRequest.getTipoEmpresa() );

        return tipoEmpresa;
    }

    protected EstadoCivil profissionalRequestToEstadoCivil(ProfissionalRequest profissionalRequest) {
        if ( profissionalRequest == null ) {
            return null;
        }

        EstadoCivil estadoCivil = new EstadoCivil();

        estadoCivil.setId( profissionalRequest.getEstadoCivil() );

        return estadoCivil;
    }
}
