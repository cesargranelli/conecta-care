package com.sevenine.conecta.mapper.tratamento.impl;

import com.sevenine.conecta.controller.data.request.tratamento.AdicionaTratamentoRequest;
import com.sevenine.conecta.mapper.tratamento.AdicionaTratamentoMapper;
import com.sevenine.conecta.repository.data.Tratamento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T14:36:57-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class AdicionaTratamentoMapperImpl implements AdicionaTratamentoMapper {

    @Override
    public Tratamento toEntityData(AdicionaTratamentoRequest request) {
        if ( request == null ) {
            return null;
        }

        Tratamento tratamento = new Tratamento();

        tratamento.setDescricao( request.getDescricao() );
        tratamento.setValorKilometragem( request.getValorKilometragem() );
        tratamento.setPacienteId( request.getPacienteId() );
        tratamento.setAcompanhanteId( request.getAcompanhanteId() );
        tratamento.setProfissionalId( request.getProfissionalId() );
        tratamento.setHomeCareId( request.getHomeCareId() );

        return tratamento;
    }
}
