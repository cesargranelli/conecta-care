package com.connecta.evento.mapper.impl;

import com.connecta.evento.controller.data.response.EnvioResponse;
import com.connecta.evento.mapper.EventoEnviaMapper;
import com.connecta.evento.service.data.request.EventoEnviaRequest;
import com.connecta.evento.service.data.response.ProfissionalEventoResponse;
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
public class EventoEnviaMapperImpl implements EventoEnviaMapper {

    @Override
    public List<EventoEnviaRequest> toRequest(List<ProfissionalEventoResponse> profissionaisEvento) {
        if ( profissionaisEvento == null ) {
            return null;
        }

        List<EventoEnviaRequest> list = new ArrayList<EventoEnviaRequest>( profissionaisEvento.size() );
        for ( ProfissionalEventoResponse profissionalEventoResponse : profissionaisEvento ) {
            list.add( profissionalEventoResponseToEventoEnviaRequest( profissionalEventoResponse ) );
        }

        return list;
    }

    @Override
    public EnvioResponse fromQuantidadeEnviados(Integer quantidadeEnviados) {
        if ( quantidadeEnviados == null ) {
            return null;
        }

        EnvioResponse envioResponse = new EnvioResponse();

        envioResponse.setQuantidadeEnviados( quantidadeEnviados );

        return envioResponse;
    }

    protected EventoEnviaRequest profissionalEventoResponseToEventoEnviaRequest(ProfissionalEventoResponse profissionalEventoResponse) {
        if ( profissionalEventoResponse == null ) {
            return null;
        }

        EventoEnviaRequest eventoEnviaRequest = new EventoEnviaRequest();

        eventoEnviaRequest.setProfissionalId( profissionalEventoResponse.getProfissionalId() );
        eventoEnviaRequest.setNumeroTelefone( profissionalEventoResponse.getNumeroTelefone() );

        return eventoEnviaRequest;
    }
}
