package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.adapter.controller.data.response.EspecialidadeResponse;
import com.sevenine.conecta.adapter.controller.data.response.EstadoResponse;
import com.sevenine.conecta.adapter.controller.data.response.EventoResponse;
import com.sevenine.conecta.mapper.EventoConsultaMapper;
import com.sevenine.conecta.repository.entity.Especialidade;
import com.sevenine.conecta.repository.entity.Estado;
import com.sevenine.conecta.repository.entity.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T01:21:06-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class EventoConsultaMapperImpl implements EventoConsultaMapper {

    @Override
    public EventoResponse fromEntityData(Evento evento) {
        if ( evento == null ) {
            return null;
        }

        EventoResponse eventoResponse = new EventoResponse();

        eventoResponse.setId( evento.getId() );
        eventoResponse.setTitulo( evento.getTitulo() );
        eventoResponse.setDescricao( evento.getDescricao() );
        eventoResponse.setDetalhe( evento.getDetalhe() );
        eventoResponse.setData( evento.getData() );
        eventoResponse.setHora( evento.getHora() );
        eventoResponse.setDataCadastro( evento.getDataCadastro() );
        eventoResponse.setUsuarioCadastro( evento.getUsuarioCadastro() );
        eventoResponse.setDataAtualizacao( evento.getDataAtualizacao() );
        eventoResponse.setUsuarioAtualizacao( evento.getUsuarioAtualizacao() );
        eventoResponse.setLogradouro( evento.getLogradouro() );
        eventoResponse.setNumero( evento.getNumero() );
        eventoResponse.setCep( evento.getCep() );
        eventoResponse.setBairro( evento.getBairro() );
        eventoResponse.setCidade( evento.getCidade() );
        eventoResponse.setDuracao( evento.getDuracao() );
        eventoResponse.setVagas( evento.getVagas() );
        if ( evento.getStatus() != null ) {
            eventoResponse.setStatus( evento.getStatus().name() );
        }
        eventoResponse.setEstado( estadoToEstadoResponse( evento.getEstado() ) );
        eventoResponse.setEspecialidades( especialidadeListToEspecialidadeResponseList( evento.getEspecialidades() ) );

        return eventoResponse;
    }

    protected EstadoResponse estadoToEstadoResponse(Estado estado) {
        if ( estado == null ) {
            return null;
        }

        EstadoResponse estadoResponse = new EstadoResponse();

        estadoResponse.setId( estado.getId() );
        estadoResponse.setUf( estado.getUf() );

        return estadoResponse;
    }

    protected EspecialidadeResponse especialidadeToEspecialidadeResponse(Especialidade especialidade) {
        if ( especialidade == null ) {
            return null;
        }

        EspecialidadeResponse especialidadeResponse = new EspecialidadeResponse();

        especialidadeResponse.setId( especialidade.getId() );
        especialidadeResponse.setNome( especialidade.getNome() );

        return especialidadeResponse;
    }

    protected List<EspecialidadeResponse> especialidadeListToEspecialidadeResponseList(List<Especialidade> list) {
        if ( list == null ) {
            return null;
        }

        List<EspecialidadeResponse> list1 = new ArrayList<EspecialidadeResponse>( list.size() );
        for ( Especialidade especialidade : list ) {
            list1.add( especialidadeToEspecialidadeResponse( especialidade ) );
        }

        return list1;
    }
}
