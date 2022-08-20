package com.sevenine.conecta.mapper.consulta.impl;

import com.sevenine.conecta.controller.data.response.TelefoneResponse;
import com.sevenine.conecta.mapper.consulta.ConsultaTelefoneMapper;
import com.sevenine.conecta.repository.data.Telefone;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaTelefoneMapperImpl implements ConsultaTelefoneMapper {

    @Override
    public TelefoneResponse fromEntityData(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }

        TelefoneResponse telefoneResponse = new TelefoneResponse();

        telefoneResponse.setId( telefone.getId() );
        telefoneResponse.setTelefoneFixo( telefone.getTelefoneFixo() );
        telefoneResponse.setTelefoneRecado( telefone.getTelefoneRecado() );
        telefoneResponse.setCelularPrincipal( telefone.getCelularPrincipal() );
        telefoneResponse.setCelularSecundario( telefone.getCelularSecundario() );

        return telefoneResponse;
    }
}
