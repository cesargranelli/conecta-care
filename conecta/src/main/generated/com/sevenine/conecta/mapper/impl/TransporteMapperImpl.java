package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaTransporteResponse;
import com.sevenine.conecta.mapper.TransporteMapper;
import com.sevenine.conecta.repository.data.Transporte;
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
public class TransporteMapperImpl implements TransporteMapper {

    @Override
    public List<ConsultaTransporteResponse> fromEntityData(List<Transporte> transportes) {
        if ( transportes == null ) {
            return null;
        }

        List<ConsultaTransporteResponse> list = new ArrayList<ConsultaTransporteResponse>( transportes.size() );
        for ( Transporte transporte : transportes ) {
            list.add( transporteToConsultaTransporteResponse( transporte ) );
        }

        return list;
    }

    protected ConsultaTransporteResponse transporteToConsultaTransporteResponse(Transporte transporte) {
        if ( transporte == null ) {
            return null;
        }

        ConsultaTransporteResponse consultaTransporteResponse = new ConsultaTransporteResponse();

        if ( transporte.getId() != null ) {
            consultaTransporteResponse.setId( transporte.getId().intValue() );
        }
        consultaTransporteResponse.setTipo( transporte.getTipo() );

        return consultaTransporteResponse;
    }
}
