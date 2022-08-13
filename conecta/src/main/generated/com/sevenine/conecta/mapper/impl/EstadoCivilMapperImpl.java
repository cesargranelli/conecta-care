package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaEstadoCivilResponse;
import com.sevenine.conecta.mapper.EstadoCivilMapper;
import com.sevenine.conecta.repository.data.EstadoCivil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-10T22:40:17-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class EstadoCivilMapperImpl implements EstadoCivilMapper {

    @Override
    public List<ConsultaEstadoCivilResponse> fromEntityData(List<EstadoCivil> estadosCivis) {
        if ( estadosCivis == null ) {
            return null;
        }

        List<ConsultaEstadoCivilResponse> list = new ArrayList<ConsultaEstadoCivilResponse>( estadosCivis.size() );
        for ( EstadoCivil estadoCivil : estadosCivis ) {
            list.add( estadoCivilToConsultaEstadoCivilResponse( estadoCivil ) );
        }

        return list;
    }

    protected ConsultaEstadoCivilResponse estadoCivilToConsultaEstadoCivilResponse(EstadoCivil estadoCivil) {
        if ( estadoCivil == null ) {
            return null;
        }

        ConsultaEstadoCivilResponse consultaEstadoCivilResponse = new ConsultaEstadoCivilResponse();

        if ( estadoCivil.getId() != null ) {
            consultaEstadoCivilResponse.setId( estadoCivil.getId().intValue() );
        }
        consultaEstadoCivilResponse.setTipo( estadoCivil.getTipo() );
        consultaEstadoCivilResponse.setDescricao( estadoCivil.getDescricao() );

        return consultaEstadoCivilResponse;
    }
}
