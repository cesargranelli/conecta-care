package com.sevenine.conecta.mapper.consulta.impl;

import com.sevenine.conecta.controller.data.response.EnderecoResponse;
import com.sevenine.conecta.controller.data.response.EstadoResponse;
import com.sevenine.conecta.controller.data.response.PaisResponse;
import com.sevenine.conecta.mapper.consulta.ConsultaEnderecoMapper;
import com.sevenine.conecta.repository.data.Endereco;
import com.sevenine.conecta.repository.data.Estado;
import com.sevenine.conecta.repository.data.Pais;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaEnderecoMapperImpl implements ConsultaEnderecoMapper {

    @Override
    public EnderecoResponse fromEntityData(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoResponse enderecoResponse = new EnderecoResponse();

        enderecoResponse.setId( endereco.getId() );
        enderecoResponse.setLogradouro( endereco.getLogradouro() );
        enderecoResponse.setNumero( endereco.getNumero() );
        enderecoResponse.setComplemento( endereco.getComplemento() );
        enderecoResponse.setBairro( endereco.getBairro() );
        enderecoResponse.setCidade( endereco.getCidade() );
        enderecoResponse.setCep( endereco.getCep() );
        enderecoResponse.setComprovante( endereco.getComprovante() );
        enderecoResponse.setEstado( estadoToEstadoResponse( endereco.getEstado() ) );
        enderecoResponse.setPais( paisToPaisResponse( endereco.getPais() ) );

        return enderecoResponse;
    }

    protected EstadoResponse estadoToEstadoResponse(Estado estado) {
        if ( estado == null ) {
            return null;
        }

        EstadoResponse estadoResponse = new EstadoResponse();

        estadoResponse.setId( estado.getId() );
        estadoResponse.setCodigo( estado.getCodigo() );
        estadoResponse.setUf( estado.getUf() );
        estadoResponse.setNome( estado.getNome() );
        estadoResponse.setRegiao( estado.getRegiao() );

        return estadoResponse;
    }

    protected PaisResponse paisToPaisResponse(Pais pais) {
        if ( pais == null ) {
            return null;
        }

        PaisResponse paisResponse = new PaisResponse();

        paisResponse.setId( pais.getId() );
        paisResponse.setCodigo( pais.getCodigo() );
        paisResponse.setNome( pais.getNome() );

        return paisResponse;
    }
}
