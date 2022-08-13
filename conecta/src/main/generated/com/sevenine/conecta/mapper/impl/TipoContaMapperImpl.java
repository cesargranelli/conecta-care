package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaTipoContaResponse;
import com.sevenine.conecta.mapper.TipoContaMapper;
import com.sevenine.conecta.repository.data.TipoConta;
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
public class TipoContaMapperImpl implements TipoContaMapper {

    @Override
    public List<ConsultaTipoContaResponse> fromEntityData(List<TipoConta> tiposContas) {
        if ( tiposContas == null ) {
            return null;
        }

        List<ConsultaTipoContaResponse> list = new ArrayList<ConsultaTipoContaResponse>( tiposContas.size() );
        for ( TipoConta tipoConta : tiposContas ) {
            list.add( tipoContaToConsultaTipoContaResponse( tipoConta ) );
        }

        return list;
    }

    protected ConsultaTipoContaResponse tipoContaToConsultaTipoContaResponse(TipoConta tipoConta) {
        if ( tipoConta == null ) {
            return null;
        }

        ConsultaTipoContaResponse consultaTipoContaResponse = new ConsultaTipoContaResponse();

        if ( tipoConta.getId() != null ) {
            consultaTipoContaResponse.setId( tipoConta.getId().intValue() );
        }
        consultaTipoContaResponse.setCodigo( tipoConta.getCodigo() );
        consultaTipoContaResponse.setDescricao( tipoConta.getDescricao() );

        return consultaTipoContaResponse;
    }
}
