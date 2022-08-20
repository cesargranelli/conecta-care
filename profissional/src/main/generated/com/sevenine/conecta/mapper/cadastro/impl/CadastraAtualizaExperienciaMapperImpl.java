package com.sevenine.conecta.mapper.cadastro.impl;

import com.sevenine.conecta.controller.data.request.ExperienciaRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaExperienciaResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaExperienciaMapper;
import com.sevenine.conecta.repository.data.Experiencia;
import com.sevenine.conecta.repository.data.Profissional;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class CadastraAtualizaExperienciaMapperImpl implements CadastraAtualizaExperienciaMapper {

    @Override
    public Experiencia toEntityData(ExperienciaRequest request) {
        if ( request == null ) {
            return null;
        }

        Experiencia experiencia = new Experiencia();

        experiencia.setProfissional( experienciaRequestToProfissional( request ) );
        experiencia.setEmpresa( request.getEmpresa() );
        experiencia.setCargo( request.getCargo() );
        experiencia.setObservacao( request.getObservacao() );
        experiencia.setPosicao( request.getPosicao() );
        experiencia.setDataAdmissao( request.getDataAdmissao() );
        experiencia.setDataDemissao( request.getDataDemissao() );

        return experiencia;
    }

    @Override
    public List<Experiencia> toEntityDataList(List<ExperienciaRequest> request) {
        if ( request == null ) {
            return null;
        }

        List<Experiencia> list = new ArrayList<Experiencia>( request.size() );
        for ( ExperienciaRequest experienciaRequest : request ) {
            list.add( toEntityData( experienciaRequest ) );
        }

        return list;
    }

    @Override
    public CadastraAtualizaExperienciaResponse fromEntityData(Long profissionalId) {
        if ( profissionalId == null ) {
            return null;
        }

        CadastraAtualizaExperienciaResponse cadastraAtualizaExperienciaResponse = new CadastraAtualizaExperienciaResponse();

        cadastraAtualizaExperienciaResponse.setProfissionalId( profissionalId );

        return cadastraAtualizaExperienciaResponse;
    }

    protected Profissional experienciaRequestToProfissional(ExperienciaRequest experienciaRequest) {
        if ( experienciaRequest == null ) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setId( experienciaRequest.getProfissionalId() );

        return profissional;
    }
}
