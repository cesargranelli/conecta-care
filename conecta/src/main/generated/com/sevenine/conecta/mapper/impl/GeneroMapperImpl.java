package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaGeneroResponse;
import com.sevenine.conecta.mapper.GeneroMapper;
import com.sevenine.conecta.repository.data.Genero;
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
public class GeneroMapperImpl implements GeneroMapper {

    @Override
    public List<ConsultaGeneroResponse> fromEntityData(List<Genero> generos) {
        if ( generos == null ) {
            return null;
        }

        List<ConsultaGeneroResponse> list = new ArrayList<ConsultaGeneroResponse>( generos.size() );
        for ( Genero genero : generos ) {
            list.add( generoToConsultaGeneroResponse( genero ) );
        }

        return list;
    }

    protected ConsultaGeneroResponse generoToConsultaGeneroResponse(Genero genero) {
        if ( genero == null ) {
            return null;
        }

        ConsultaGeneroResponse consultaGeneroResponse = new ConsultaGeneroResponse();

        if ( genero.getId() != null ) {
            consultaGeneroResponse.setId( genero.getId().intValue() );
        }
        consultaGeneroResponse.setTipo( genero.getTipo() );
        consultaGeneroResponse.setDescricao( genero.getDescricao() );

        return consultaGeneroResponse;
    }
}
