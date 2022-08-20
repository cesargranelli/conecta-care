package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaTipoEmpresaResponse;
import com.sevenine.conecta.mapper.TipoEmpresaMapper;
import com.sevenine.conecta.repository.data.TipoEmpresa;
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
public class TipoEmpresaMapperImpl implements TipoEmpresaMapper {

    @Override
    public List<ConsultaTipoEmpresaResponse> fromEntityData(List<TipoEmpresa> tiposEmpresas) {
        if ( tiposEmpresas == null ) {
            return null;
        }

        List<ConsultaTipoEmpresaResponse> list = new ArrayList<ConsultaTipoEmpresaResponse>( tiposEmpresas.size() );
        for ( TipoEmpresa tipoEmpresa : tiposEmpresas ) {
            list.add( tipoEmpresaToConsultaTipoEmpresaResponse( tipoEmpresa ) );
        }

        return list;
    }

    protected ConsultaTipoEmpresaResponse tipoEmpresaToConsultaTipoEmpresaResponse(TipoEmpresa tipoEmpresa) {
        if ( tipoEmpresa == null ) {
            return null;
        }

        ConsultaTipoEmpresaResponse consultaTipoEmpresaResponse = new ConsultaTipoEmpresaResponse();

        if ( tipoEmpresa.getId() != null ) {
            consultaTipoEmpresaResponse.setId( tipoEmpresa.getId().intValue() );
        }
        consultaTipoEmpresaResponse.setSigla( tipoEmpresa.getSigla() );
        consultaTipoEmpresaResponse.setTipo( tipoEmpresa.getTipo() );
        consultaTipoEmpresaResponse.setDescricao( tipoEmpresa.getDescricao() );

        return consultaTipoEmpresaResponse;
    }
}
