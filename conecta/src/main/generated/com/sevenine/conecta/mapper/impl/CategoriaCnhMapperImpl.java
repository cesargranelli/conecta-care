package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaCategoriaCnhResponse;
import com.sevenine.conecta.mapper.CategoriaCnhMapper;
import com.sevenine.conecta.repository.data.CategoriaCnh;
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
public class CategoriaCnhMapperImpl implements CategoriaCnhMapper {

    @Override
    public List<ConsultaCategoriaCnhResponse> fromEntityData(List<CategoriaCnh> categoriasCnh) {
        if ( categoriasCnh == null ) {
            return null;
        }

        List<ConsultaCategoriaCnhResponse> list = new ArrayList<ConsultaCategoriaCnhResponse>( categoriasCnh.size() );
        for ( CategoriaCnh categoriaCnh : categoriasCnh ) {
            list.add( categoriaCnhToConsultaCategoriaCnhResponse( categoriaCnh ) );
        }

        return list;
    }

    protected ConsultaCategoriaCnhResponse categoriaCnhToConsultaCategoriaCnhResponse(CategoriaCnh categoriaCnh) {
        if ( categoriaCnh == null ) {
            return null;
        }

        ConsultaCategoriaCnhResponse consultaCategoriaCnhResponse = new ConsultaCategoriaCnhResponse();

        if ( categoriaCnh.getId() != null ) {
            consultaCategoriaCnhResponse.setId( categoriaCnh.getId().intValue() );
        }
        consultaCategoriaCnhResponse.setSigla( categoriaCnh.getSigla() );

        return consultaCategoriaCnhResponse;
    }
}
