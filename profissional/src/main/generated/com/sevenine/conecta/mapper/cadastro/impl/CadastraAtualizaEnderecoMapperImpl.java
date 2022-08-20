package com.sevenine.conecta.mapper.cadastro.impl;

import com.sevenine.conecta.controller.data.request.EnderecoRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaEnderecoResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaEnderecoMapper;
import com.sevenine.conecta.repository.data.Endereco;
import com.sevenine.conecta.repository.data.Estado;
import com.sevenine.conecta.repository.data.Pais;
import com.sevenine.conecta.repository.data.Profissional;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class CadastraAtualizaEnderecoMapperImpl implements CadastraAtualizaEnderecoMapper {

    @Override
    public Endereco toEntityData(EnderecoRequest request) {
        if ( request == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setProfissional( enderecoRequestToProfissional( request ) );
        endereco.setEstado( enderecoRequestToEstado( request ) );
        endereco.setPais( enderecoRequestToPais( request ) );
        endereco.setId( request.getId() );
        endereco.setLogradouro( request.getLogradouro() );
        endereco.setNumero( request.getNumero() );
        endereco.setComplemento( request.getComplemento() );
        endereco.setBairro( request.getBairro() );
        endereco.setCidade( request.getCidade() );
        endereco.setCep( request.getCep() );
        endereco.setComprovante( request.getComprovante() );

        return endereco;
    }

    @Override
    public CadastraAtualizaEnderecoResponse fromEntityData(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        CadastraAtualizaEnderecoResponse cadastraAtualizaEnderecoResponse = new CadastraAtualizaEnderecoResponse();

        cadastraAtualizaEnderecoResponse.setProfissionalId( enderecoProfissionalId( endereco ) );

        return cadastraAtualizaEnderecoResponse;
    }

    protected Profissional enderecoRequestToProfissional(EnderecoRequest enderecoRequest) {
        if ( enderecoRequest == null ) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setId( enderecoRequest.getProprietarioId() );

        return profissional;
    }

    protected Estado enderecoRequestToEstado(EnderecoRequest enderecoRequest) {
        if ( enderecoRequest == null ) {
            return null;
        }

        Estado estado = new Estado();

        if ( enderecoRequest.getEstado() != null ) {
            estado.setId( Long.parseLong( enderecoRequest.getEstado() ) );
        }

        return estado;
    }

    protected Pais enderecoRequestToPais(EnderecoRequest enderecoRequest) {
        if ( enderecoRequest == null ) {
            return null;
        }

        Pais pais = new Pais();

        if ( enderecoRequest.getPais() != null ) {
            pais.setId( Long.parseLong( enderecoRequest.getPais() ) );
        }

        return pais;
    }

    private Long enderecoProfissionalId(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }
        Profissional profissional = endereco.getProfissional();
        if ( profissional == null ) {
            return null;
        }
        Long id = profissional.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
