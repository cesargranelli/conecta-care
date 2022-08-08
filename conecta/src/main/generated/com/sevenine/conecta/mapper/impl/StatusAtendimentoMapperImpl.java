package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaStatusAtendimentoResponse;
import com.sevenine.conecta.mapper.StatusAtendimentoMapper;
import com.sevenine.conecta.repository.data.StatusAtendimento;
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
public class StatusAtendimentoMapperImpl implements StatusAtendimentoMapper {

    @Override
    public List<ConsultaStatusAtendimentoResponse> fromEntityData(List<StatusAtendimento> statusAtendimentos) {
        if ( statusAtendimentos == null ) {
            return null;
        }

        List<ConsultaStatusAtendimentoResponse> list = new ArrayList<ConsultaStatusAtendimentoResponse>( statusAtendimentos.size() );
        for ( StatusAtendimento statusAtendimento : statusAtendimentos ) {
            list.add( statusAtendimentoToConsultaStatusAtendimentoResponse( statusAtendimento ) );
        }

        return list;
    }

    protected ConsultaStatusAtendimentoResponse statusAtendimentoToConsultaStatusAtendimentoResponse(StatusAtendimento statusAtendimento) {
        if ( statusAtendimento == null ) {
            return null;
        }

        ConsultaStatusAtendimentoResponse consultaStatusAtendimentoResponse = new ConsultaStatusAtendimentoResponse();

        if ( statusAtendimento.getId() != null ) {
            consultaStatusAtendimentoResponse.setId( statusAtendimento.getId().intValue() );
        }
        consultaStatusAtendimentoResponse.setDescricao( statusAtendimento.getDescricao() );
        consultaStatusAtendimentoResponse.setStatus( statusAtendimento.getStatus() );

        return consultaStatusAtendimentoResponse;
    }
}
