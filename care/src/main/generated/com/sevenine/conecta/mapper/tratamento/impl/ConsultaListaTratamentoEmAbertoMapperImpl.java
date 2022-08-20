package com.sevenine.conecta.mapper.tratamento.impl;

import com.sevenine.conecta.mapper.tratamento.ConsultaListaTratamentoEmAbertoMapper;
import com.sevenine.conecta.repository.data.Tratamento;
import com.sevenine.conecta.service.data.response.ConsultaListaTratamentoResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T14:36:58-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaListaTratamentoEmAbertoMapperImpl implements ConsultaListaTratamentoEmAbertoMapper {

    @Override
    public ConsultaListaTratamentoResponse fromTratamentoData(Tratamento tratamento) {
        if ( tratamento == null ) {
            return null;
        }

        ConsultaListaTratamentoResponse consultaListaTratamentoResponse = new ConsultaListaTratamentoResponse();

        consultaListaTratamentoResponse.setId( tratamento.getId() );
        consultaListaTratamentoResponse.setDescricao( tratamento.getDescricao() );
        consultaListaTratamentoResponse.setPacienteId( tratamento.getPacienteId() );

        consultaListaTratamentoResponse.setStatus( tratamento.getSituacoes().stream().findFirst().orElse(new com.sevenine.conecta.repository.data.TratamentoSituacao()).getStatus() );

        return consultaListaTratamentoResponse;
    }

    @Override
    public List<ConsultaListaTratamentoResponse> fromEntityDataList(List<Tratamento> tratamentos) {
        if ( tratamentos == null ) {
            return null;
        }

        List<ConsultaListaTratamentoResponse> list = new ArrayList<ConsultaListaTratamentoResponse>( tratamentos.size() );
        for ( Tratamento tratamento : tratamentos ) {
            list.add( fromTratamentoData( tratamento ) );
        }

        return list;
    }
}
