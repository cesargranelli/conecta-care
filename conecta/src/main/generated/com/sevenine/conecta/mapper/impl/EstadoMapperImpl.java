package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaEstadoResponse;
import com.sevenine.conecta.mapper.EstadoMapper;
import com.sevenine.conecta.repository.data.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-19T21:51:16-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class EstadoMapperImpl implements EstadoMapper {

    @Override
    public List<ConsultaEstadoResponse> fromEntityData(List<Estado> estados) {
        if ( estados == null ) {
            return null;
        }

        List<ConsultaEstadoResponse> list = new ArrayList<ConsultaEstadoResponse>( estados.size() );
        for ( Estado estado : estados ) {
            list.add( estadoToConsultaEstadoResponse( estado ) );
        }

        return list;
    }

    protected ConsultaEstadoResponse estadoToConsultaEstadoResponse(Estado estado) {
        if ( estado == null ) {
            return null;
        }

        ConsultaEstadoResponse consultaEstadoResponse = new ConsultaEstadoResponse();

        if ( estado.getId() != null ) {
            consultaEstadoResponse.setId( estado.getId().intValue() );
        }
        consultaEstadoResponse.setUf( estado.getUf() );

        return consultaEstadoResponse;
    }
}
