package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaAreaAtendimentoResponse;
import com.sevenine.conecta.mapper.AreaAtendimentoMapper;
import com.sevenine.conecta.repository.data.AreaAtendimento;
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
public class AreaAtendimentoMapperImpl implements AreaAtendimentoMapper {

    @Override
    public List<ConsultaAreaAtendimentoResponse> fromEntityData(List<AreaAtendimento> areasAtendimentos) {
        if ( areasAtendimentos == null ) {
            return null;
        }

        List<ConsultaAreaAtendimentoResponse> list = new ArrayList<ConsultaAreaAtendimentoResponse>( areasAtendimentos.size() );
        for ( AreaAtendimento areaAtendimento : areasAtendimentos ) {
            list.add( areaAtendimentoToConsultaAreaAtendimentoResponse( areaAtendimento ) );
        }

        return list;
    }

    protected ConsultaAreaAtendimentoResponse areaAtendimentoToConsultaAreaAtendimentoResponse(AreaAtendimento areaAtendimento) {
        if ( areaAtendimento == null ) {
            return null;
        }

        ConsultaAreaAtendimentoResponse consultaAreaAtendimentoResponse = new ConsultaAreaAtendimentoResponse();

        if ( areaAtendimento.getId() != null ) {
            consultaAreaAtendimentoResponse.setId( areaAtendimento.getId().intValue() );
        }
        consultaAreaAtendimentoResponse.setNome( areaAtendimento.getNome() );

        return consultaAreaAtendimentoResponse;
    }
}
