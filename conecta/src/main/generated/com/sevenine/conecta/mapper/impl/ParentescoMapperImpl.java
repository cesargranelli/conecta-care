package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaParentescoResponse;
import com.sevenine.conecta.mapper.ParentescoMapper;
import com.sevenine.conecta.repository.data.Parentesco;
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
public class ParentescoMapperImpl implements ParentescoMapper {

    @Override
    public List<ConsultaParentescoResponse> fromEntityData(List<Parentesco> parentescos) {
        if ( parentescos == null ) {
            return null;
        }

        List<ConsultaParentescoResponse> list = new ArrayList<ConsultaParentescoResponse>( parentescos.size() );
        for ( Parentesco parentesco : parentescos ) {
            list.add( parentescoToConsultaParentescoResponse( parentesco ) );
        }

        return list;
    }

    protected ConsultaParentescoResponse parentescoToConsultaParentescoResponse(Parentesco parentesco) {
        if ( parentesco == null ) {
            return null;
        }

        ConsultaParentescoResponse consultaParentescoResponse = new ConsultaParentescoResponse();

        if ( parentesco.getId() != null ) {
            consultaParentescoResponse.setId( parentesco.getId().intValue() );
        }
        consultaParentescoResponse.setDescricao( parentesco.getDescricao() );

        return consultaParentescoResponse;
    }
}
