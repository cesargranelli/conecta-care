package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.http.resource.AcompanhanteResource;
import com.sevenine.conecta.http.resource.AcompanhanteResponseResource;
import com.sevenine.conecta.http.resource.AcompanhanteResponseResource.AcompanhanteResponseResourceBuilder;
import com.sevenine.conecta.http.resource.ContatoResource;
import com.sevenine.conecta.http.resource.GeneroResource;
import com.sevenine.conecta.http.resource.ParentescoResource;
import com.sevenine.conecta.mapper.AdicionaAcompanhanteMapper;
import com.sevenine.conecta.repository.entity.AcompanhanteEntity;
import com.sevenine.conecta.repository.entity.ContatoEntity;
import com.sevenine.conecta.repository.entity.ContatoEntity.ContatoEntityBuilder;
import com.sevenine.conecta.repository.entity.GeneroEntity;
import com.sevenine.conecta.repository.entity.GeneroEntity.GeneroEntityBuilder;
import com.sevenine.conecta.repository.entity.ParentescoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T01:20:58-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class AdicionaAcompanhanteMapperImpl implements AdicionaAcompanhanteMapper {

    @Override
    public AcompanhanteEntity toEntityData(AcompanhanteResource acompanhante) {
        if ( acompanhante == null ) {
            return null;
        }

        AcompanhanteEntity acompanhanteEntity = new AcompanhanteEntity();

        acompanhanteEntity.setNomeCompleto( acompanhante.getNomeCompleto() );
        acompanhanteEntity.setCpf( acompanhante.getCpf() );
        acompanhanteEntity.setDataNascimento( acompanhante.getDataNascimento() );
        acompanhanteEntity.setGenero( generoResourceToGeneroEntity( acompanhante.getGenero() ) );
        acompanhanteEntity.setParentesco( parentescoResourceToParentescoEntity( acompanhante.getParentesco() ) );
        acompanhanteEntity.setContato( contatoResourceToContatoEntity( acompanhante.getContato() ) );
        acompanhanteEntity.setPacienteId( acompanhante.getPacienteId() );

        return acompanhanteEntity;
    }

    @Override
    public AcompanhanteResponseResource fromEntityData(AcompanhanteEntity acompanhante) {
        if ( acompanhante == null ) {
            return null;
        }

        AcompanhanteResponseResourceBuilder acompanhanteResponseResource = AcompanhanteResponseResource.builder();

        acompanhanteResponseResource.id( acompanhante.getId() );

        return acompanhanteResponseResource.build();
    }

    protected GeneroEntity generoResourceToGeneroEntity(GeneroResource generoResource) {
        if ( generoResource == null ) {
            return null;
        }

        GeneroEntityBuilder generoEntity = GeneroEntity.builder();

        generoEntity.id( generoResource.getId() );
        generoEntity.tipo( generoResource.getTipo() );
        generoEntity.descricao( generoResource.getDescricao() );

        return generoEntity.build();
    }

    protected ParentescoEntity parentescoResourceToParentescoEntity(ParentescoResource parentescoResource) {
        if ( parentescoResource == null ) {
            return null;
        }

        ParentescoEntity parentescoEntity = new ParentescoEntity();

        parentescoEntity.setId( parentescoResource.getId() );
        parentescoEntity.setDescricao( parentescoResource.getDescricao() );

        return parentescoEntity;
    }

    protected ContatoEntity contatoResourceToContatoEntity(ContatoResource contatoResource) {
        if ( contatoResource == null ) {
            return null;
        }

        ContatoEntityBuilder contatoEntity = ContatoEntity.builder();

        contatoEntity.id( contatoResource.getId() );
        contatoEntity.telefoneFixo( contatoResource.getTelefoneFixo() );
        contatoEntity.telefoneRecado( contatoResource.getTelefoneRecado() );
        contatoEntity.telefoneCelular( contatoResource.getTelefoneCelular() );
        contatoEntity.telefoneResponsavel( contatoResource.getTelefoneResponsavel() );
        contatoEntity.emailResponsavel( contatoResource.getEmailResponsavel() );

        return contatoEntity.build();
    }
}
