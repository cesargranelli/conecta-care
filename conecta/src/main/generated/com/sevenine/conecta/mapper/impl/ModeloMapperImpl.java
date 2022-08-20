package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaGrupoResponse;
import com.sevenine.conecta.controller.data.response.ConsultaModeloResponse;
import com.sevenine.conecta.mapper.ModeloMapper;
import com.sevenine.conecta.repository.data.Grupo;
import com.sevenine.conecta.repository.data.Modelo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-19T21:51:15-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ModeloMapperImpl implements ModeloMapper {

    @Override
    public List<ConsultaModeloResponse> fromEntityData(List<Modelo> modelos) {
        if ( modelos == null ) {
            return null;
        }

        List<ConsultaModeloResponse> list = new ArrayList<ConsultaModeloResponse>( modelos.size() );
        for ( Modelo modelo : modelos ) {
            list.add( modeloToConsultaModeloResponse( modelo ) );
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

    protected List<ConsultaGrupoResponse> grupoListToConsultaGrupoResponseList(List<Grupo> list) {
        if ( list == null ) {
            return null;
        }

        List<ConsultaGrupoResponse> list1 = new ArrayList<ConsultaGrupoResponse>( list.size() );
        for ( Grupo grupo : list ) {
            list1.add( grupoToConsultaGrupoResponse( grupo ) );
        }

        return list1;
    }

    protected ConsultaModeloResponse modeloToConsultaModeloResponse(Modelo modelo) {
        if ( modelo == null ) {
            return null;
        }

        ConsultaModeloResponse consultaModeloResponse = new ConsultaModeloResponse();

        if ( modelo.getId() != null ) {
            consultaModeloResponse.setId( modelo.getId().intValue() );
        }
        consultaModeloResponse.setDescricao( modelo.getDescricao() );
        consultaModeloResponse.setGrupos( grupoListToConsultaGrupoResponseList( modelo.getGrupos() ) );

        return consultaModeloResponse;
    }
}
