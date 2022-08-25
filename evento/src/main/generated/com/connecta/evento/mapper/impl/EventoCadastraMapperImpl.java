package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controllers.data.request.EstadoRequest;
import com.sevenine.conecta.controllers.data.request.EventoRequest;
import com.sevenine.conecta.mapper.EventoCadastraMapper;
import com.sevenine.conecta.repository.entity.Estado;
import com.sevenine.conecta.repository.entity.Evento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T01:21:06-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class EventoCadastraMapperImpl implements EventoCadastraMapper {

    @Override
    public Evento toEntityData(EventoRequest request) {
        if ( request == null ) {
            return null;
        }

        Evento evento = new Evento();

        evento.setUsuarioCadastro( request.getUsuario() );
        evento.setTitulo( request.getTitulo() );
        evento.setDescricao( request.getDescricao() );
        evento.setDetalhe( request.getDetalhe() );
        evento.setData( request.getData() );
        evento.setHora( request.getHora() );
        evento.setLogradouro( request.getLogradouro() );
        evento.setNumero( request.getNumero() );
        evento.setCep( request.getCep() );
        evento.setBairro( request.getBairro() );
        evento.setCidade( request.getCidade() );
        evento.setDuracao( request.getDuracao() );
        evento.setVagas( request.getVagas() );
        evento.setEstado( estadoRequestToEstado( request.getEstado() ) );

        evento.setDataCadastro( java.time.LocalDateTime.now() );

        return evento;
    }

    protected Estado estadoRequestToEstado(EstadoRequest estadoRequest) {
        if ( estadoRequest == null ) {
            return null;
        }

        Estado estado = new Estado();

        estado.setId( estadoRequest.getId() );
        estado.setUf( estadoRequest.getUf() );

        return estado;
    }
}
