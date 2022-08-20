package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.http.resource.AcompanhanteResponseResource;
import com.sevenine.conecta.http.resource.AcompanhanteResponseResource.AcompanhanteResponseResourceBuilder;
import com.sevenine.conecta.http.resource.ContatoResource;
import com.sevenine.conecta.http.resource.ContatoResource.ContatoResourceBuilder;
import com.sevenine.conecta.http.resource.GeneroResource;
import com.sevenine.conecta.http.resource.GeneroResource.GeneroResourceBuilder;
import com.sevenine.conecta.http.resource.ParentescoResource;
import com.sevenine.conecta.http.resource.ParentescoResource.ParentescoResourceBuilder;
import com.sevenine.conecta.mapper.ConsultaAcompanhanteMapper;
import com.sevenine.conecta.repository.entity.AcompanhanteEntity;
import com.sevenine.conecta.repository.entity.ContatoEntity;
import com.sevenine.conecta.repository.entity.GeneroEntity;
import com.sevenine.conecta.repository.entity.ParentescoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T01:20:59-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaAcompanhanteMapperImpl implements ConsultaAcompanhanteMapper {

    @Override
    public AcompanhanteResponseResource fromEntityData(AcompanhanteEntity acompanhante) {
        if ( acompanhante == null ) {
            return null;
        }

        AcompanhanteResponseResourceBuilder acompanhanteResponseResource = AcompanhanteResponseResource.builder();

        acompanhanteResponseResource.id( acompanhante.getId() );
        acompanhanteResponseResource.nomeCompleto( acompanhante.getNomeCompleto() );
        acompanhanteResponseResource.cpf( acompanhante.getCpf() );
        acompanhanteResponseResource.dataNascimento( acompanhante.getDataNascimento() );
        acompanhanteResponseResource.genero( generoEntityToGeneroResource( acompanhante.getGenero() ) );
        acompanhanteResponseResource.parentesco( parentescoEntityToParentescoResource( acompanhante.getParentesco() ) );
        acompanhanteResponseResource.contato( contatoEntityToContatoResource( acompanhante.getContato() ) );

        return acompanhanteResponseResource.build();
    }

    @Override
    public List<AcompanhanteResponseResource> fromEntityDataList(List<AcompanhanteEntity> acompanhantes) {
        if ( acompanhantes == null ) {
            return null;
        }

        List<AcompanhanteResponseResource> list = new ArrayList<AcompanhanteResponseResource>( acompanhantes.size() );
        for ( AcompanhanteEntity acompanhanteEntity : acompanhantes ) {
            list.add( fromEntityData( acompanhanteEntity ) );
        }

        return list;
    }

    protected GeneroResource generoEntityToGeneroResource(GeneroEntity generoEntity) {
        if ( generoEntity == null ) {
            return null;
        }

        GeneroResourceBuilder generoResource = GeneroResource.builder();

        generoResource.id( generoEntity.getId() );
        generoResource.tipo( generoEntity.getTipo() );
        generoResource.descricao( generoEntity.getDescricao() );

        return generoResource.build();
    }

    protected ParentescoResource parentescoEntityToParentescoResource(ParentescoEntity parentescoEntity) {
        if ( parentescoEntity == null ) {
            return null;
        }

        ParentescoResourceBuilder parentescoResource = ParentescoResource.builder();

        parentescoResource.id( parentescoEntity.getId() );
        parentescoResource.descricao( parentescoEntity.getDescricao() );

        return parentescoResource.build();
    }

    protected ContatoResource contatoEntityToContatoResource(ContatoEntity contatoEntity) {
        if ( contatoEntity == null ) {
            return null;
        }

        ContatoResourceBuilder contatoResource = ContatoResource.builder();

        contatoResource.id( contatoEntity.getId() );
        contatoResource.telefoneFixo( contatoEntity.getTelefoneFixo() );
        contatoResource.telefoneRecado( contatoEntity.getTelefoneRecado() );
        contatoResource.telefoneCelular( contatoEntity.getTelefoneCelular() );
        contatoResource.telefoneResponsavel( contatoEntity.getTelefoneResponsavel() );
        contatoResource.emailResponsavel( contatoEntity.getEmailResponsavel() );

        return contatoResource.build();
    }
}
