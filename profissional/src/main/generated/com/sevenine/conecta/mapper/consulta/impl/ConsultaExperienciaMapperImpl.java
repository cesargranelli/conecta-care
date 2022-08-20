package com.sevenine.conecta.mapper.consulta.impl;

import com.sevenine.conecta.controller.data.response.ExperienciaResponse;
import com.sevenine.conecta.mapper.consulta.ConsultaExperienciaMapper;
import com.sevenine.conecta.repository.data.Experiencia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaExperienciaMapperImpl implements ConsultaExperienciaMapper {

    @Override
    public ExperienciaResponse fromEntityData(Experiencia experiencia) {
        if ( experiencia == null ) {
            return null;
        }

        ExperienciaResponse experienciaResponse = new ExperienciaResponse();

        experienciaResponse.setId( experiencia.getId() );
        experienciaResponse.setEmpresa( experiencia.getEmpresa() );
        experienciaResponse.setCargo( experiencia.getCargo() );
        experienciaResponse.setDataAdmissao( experiencia.getDataAdmissao() );
        experienciaResponse.setDataDemissao( experiencia.getDataDemissao() );
        experienciaResponse.setObservacao( experiencia.getObservacao() );
        experienciaResponse.setPosicao( experiencia.getPosicao() );

        return experienciaResponse;
    }

    @Override
    public List<ExperienciaResponse> fromEntityDataList(List<Experiencia> experiencia) {
        if ( experiencia == null ) {
            return null;
        }

        List<ExperienciaResponse> list = new ArrayList<ExperienciaResponse>( experiencia.size() );
        for ( Experiencia experiencia1 : experiencia ) {
            list.add( fromEntityData( experiencia1 ) );
        }

        return list;
    }
}
