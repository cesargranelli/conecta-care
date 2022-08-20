package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.EstadoCivilResponse;
import com.sevenine.conecta.controller.data.response.GeneroResponse;
import com.sevenine.conecta.controller.data.response.ProfissionalResponse;
import com.sevenine.conecta.controller.data.response.TipoEmpresaResponse;
import com.sevenine.conecta.mapper.ProfissionalMapper;
import com.sevenine.conecta.repository.data.EstadoCivil;
import com.sevenine.conecta.repository.data.Genero;
import com.sevenine.conecta.repository.data.Profissional;
import com.sevenine.conecta.repository.data.TipoEmpresa;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ProfissionalMapperImpl implements ProfissionalMapper {

    @Override
    public ProfissionalResponse fromEntityData(Profissional profissional) {
        if ( profissional == null ) {
            return null;
        }

        ProfissionalResponse profissionalResponse = new ProfissionalResponse();

        if ( profissional.getDataNascimento() != null ) {
            profissionalResponse.setDataNascimento( DateTimeFormatter.ofPattern( "dd/MM/yyyy" ).format( profissional.getDataNascimento() ) );
        }
        if ( profissional.getRgDataEmissao() != null ) {
            profissionalResponse.setRgDataEmissao( DateTimeFormatter.ofPattern( "dd/MM/yyyy" ).format( profissional.getRgDataEmissao() ) );
        }
        profissionalResponse.setId( profissional.getId() );
        profissionalResponse.setCpf( profissional.getCpf() );
        profissionalResponse.setNome( profissional.getNome() );
        profissionalResponse.setSobrenome( profissional.getSobrenome() );
        profissionalResponse.setRg( profissional.getRg() );
        profissionalResponse.setRgEmissor( profissional.getRgEmissor() );
        profissionalResponse.setCnpj( profissional.getCnpj() );
        profissionalResponse.setCtps( profissional.getCtps() );
        profissionalResponse.setCtpsSerie( profissional.getCtpsSerie() );
        profissionalResponse.setPis( profissional.getPis() );
        profissionalResponse.setFotoCtps( profissional.getFotoCtps() );
        profissionalResponse.setFotoProfissional( profissional.getFotoProfissional() );
        profissionalResponse.setFotoRgFrente( profissional.getFotoRgFrente() );
        profissionalResponse.setFotoRgVerso( profissional.getFotoRgVerso() );
        profissionalResponse.setFotoAssinatura( profissional.getFotoAssinatura() );
        profissionalResponse.setDisponivelParaAtendimento( profissional.getDisponivelParaAtendimento() );
        profissionalResponse.setGenero( generoToGeneroResponse( profissional.getGenero() ) );
        profissionalResponse.setTipoEmpresa( tipoEmpresaToTipoEmpresaResponse( profissional.getTipoEmpresa() ) );
        profissionalResponse.setEstadoCivil( estadoCivilToEstadoCivilResponse( profissional.getEstadoCivil() ) );

        return profissionalResponse;
    }

    protected GeneroResponse generoToGeneroResponse(Genero genero) {
        if ( genero == null ) {
            return null;
        }

        GeneroResponse generoResponse = new GeneroResponse();

        generoResponse.setId( genero.getId() );
        generoResponse.setTipo( genero.getTipo() );
        generoResponse.setDescricao( genero.getDescricao() );

        return generoResponse;
    }

    protected TipoEmpresaResponse tipoEmpresaToTipoEmpresaResponse(TipoEmpresa tipoEmpresa) {
        if ( tipoEmpresa == null ) {
            return null;
        }

        TipoEmpresaResponse tipoEmpresaResponse = new TipoEmpresaResponse();

        tipoEmpresaResponse.setId( tipoEmpresa.getId() );
        tipoEmpresaResponse.setSigla( tipoEmpresa.getSigla() );
        tipoEmpresaResponse.setTipo( tipoEmpresa.getTipo() );
        tipoEmpresaResponse.setDescricao( tipoEmpresa.getDescricao() );

        return tipoEmpresaResponse;
    }

    protected EstadoCivilResponse estadoCivilToEstadoCivilResponse(EstadoCivil estadoCivil) {
        if ( estadoCivil == null ) {
            return null;
        }

        EstadoCivilResponse estadoCivilResponse = new EstadoCivilResponse();

        estadoCivilResponse.setId( estadoCivil.getId() );
        estadoCivilResponse.setTipo( estadoCivil.getTipo() );
        estadoCivilResponse.setDescricao( estadoCivil.getDescricao() );

        return estadoCivilResponse;
    }
}
