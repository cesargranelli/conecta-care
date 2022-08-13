package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaConselhoResponse;
import com.sevenine.conecta.mapper.ConselhoMapper;
import com.sevenine.conecta.repository.data.Conselho;
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
public class ConselhoMapperImpl implements ConselhoMapper {

    @Override
    public List<ConsultaConselhoResponse> fromEntityData(List<Conselho> conselhos) {
        if ( conselhos == null ) {
            return null;
        }

        List<ConsultaConselhoResponse> list = new ArrayList<ConsultaConselhoResponse>( conselhos.size() );
        for ( Conselho conselho : conselhos ) {
            list.add( conselhoToConsultaConselhoResponse( conselho ) );
        }

        return list;
    }

    protected ConsultaConselhoResponse conselhoToConsultaConselhoResponse(Conselho conselho) {
        if ( conselho == null ) {
            return null;
        }

        ConsultaConselhoResponse consultaConselhoResponse = new ConsultaConselhoResponse();

        if ( conselho.getId() != null ) {
            consultaConselhoResponse.setId( conselho.getId().intValue() );
        }
        consultaConselhoResponse.setSigla( conselho.getSigla() );
        consultaConselhoResponse.setDescricao( conselho.getDescricao() );

        return consultaConselhoResponse;
    }
}
