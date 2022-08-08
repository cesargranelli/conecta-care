package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaGrupoResponse;
import com.sevenine.conecta.mapper.GrupoMapper;
import com.sevenine.conecta.repository.data.Grupo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T09:19:59-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class GrupoMapperImpl implements GrupoMapper {

    @Override
    public List<ConsultaGrupoResponse> fromEntityData(List<Grupo> grupos) {
        if ( grupos == null ) {
            return null;
        }

        List<ConsultaGrupoResponse> list = new ArrayList<ConsultaGrupoResponse>( grupos.size() );
        for ( Grupo grupo : grupos ) {
            list.add( grupoToConsultaGrupoResponse( grupo ) );
        }

        return list;
    }

    protected ConsultaGrupoResponse grupoToConsultaGrupoResponse(Grupo grupo) {
        if ( grupo == null ) {
            return null;
        }

        ConsultaGrupoResponse consultaGrupoResponse = new ConsultaGrupoResponse();

        if ( grupo.getId() != null ) {
            consultaGrupoResponse.setId( grupo.getId().intValue() );
        }
        consultaGrupoResponse.setDescricao( grupo.getDescricao() );

        return consultaGrupoResponse;
    }
}
