package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaPaisResponse;
import com.sevenine.conecta.mapper.PaisMapper;
import com.sevenine.conecta.repository.data.Pais;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T09:19:58-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class PaisMapperImpl implements PaisMapper {

    @Override
    public List<ConsultaPaisResponse> fromEntityData(List<Pais> paises) {
        if ( paises == null ) {
            return null;
        }

        List<ConsultaPaisResponse> list = new ArrayList<ConsultaPaisResponse>( paises.size() );
        for ( Pais pais : paises ) {
            list.add( paisToConsultaPaisResponse( pais ) );
        }

        return list;
    }

    protected ConsultaPaisResponse paisToConsultaPaisResponse(Pais pais) {
        if ( pais == null ) {
            return null;
        }

        ConsultaPaisResponse consultaPaisResponse = new ConsultaPaisResponse();

        if ( pais.getId() != null ) {
            consultaPaisResponse.setId( pais.getId().intValue() );
        }
        consultaPaisResponse.setCodigo( pais.getCodigo() );
        consultaPaisResponse.setNome( pais.getNome() );

        return consultaPaisResponse;
    }
}
