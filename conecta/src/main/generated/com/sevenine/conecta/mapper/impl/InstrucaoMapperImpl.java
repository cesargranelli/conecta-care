package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaInstrucaoResponse;
import com.sevenine.conecta.mapper.InstrucaoMapper;
import com.sevenine.conecta.repository.data.Instrucao;
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
public class InstrucaoMapperImpl implements InstrucaoMapper {

    @Override
    public List<ConsultaInstrucaoResponse> fromEntityData(List<Instrucao> instrucoes) {
        if ( instrucoes == null ) {
            return null;
        }

        List<ConsultaInstrucaoResponse> list = new ArrayList<ConsultaInstrucaoResponse>( instrucoes.size() );
        for ( Instrucao instrucao : instrucoes ) {
            list.add( instrucaoToConsultaInstrucaoResponse( instrucao ) );
        }

        return list;
    }

    protected ConsultaInstrucaoResponse instrucaoToConsultaInstrucaoResponse(Instrucao instrucao) {
        if ( instrucao == null ) {
            return null;
        }

        ConsultaInstrucaoResponse consultaInstrucaoResponse = new ConsultaInstrucaoResponse();

        if ( instrucao.getId() != null ) {
            consultaInstrucaoResponse.setId( instrucao.getId().intValue() );
        }
        consultaInstrucaoResponse.setGrau( instrucao.getGrau() );

        return consultaInstrucaoResponse;
    }
}
