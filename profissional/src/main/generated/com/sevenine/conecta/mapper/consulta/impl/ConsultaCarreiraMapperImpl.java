package com.sevenine.conecta.mapper.consulta.impl;

import com.sevenine.conecta.controller.data.response.AreaAtendimentoResponse;
import com.sevenine.conecta.controller.data.response.CarreiraResponse;
import com.sevenine.conecta.controller.data.response.ConselhoResponse;
import com.sevenine.conecta.controller.data.response.EstadoResponse;
import com.sevenine.conecta.controller.data.response.TransporteResponse;
import com.sevenine.conecta.mapper.consulta.ConsultaCarreiraMapper;
import com.sevenine.conecta.repository.data.AreaAtendimento;
import com.sevenine.conecta.repository.data.Carreira;
import com.sevenine.conecta.repository.data.Conselho;
import com.sevenine.conecta.repository.data.Estado;
import com.sevenine.conecta.repository.data.Transporte;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:51-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaCarreiraMapperImpl implements ConsultaCarreiraMapper {

    @Override
    public CarreiraResponse fromEntityData(Carreira carreira) {
        if ( carreira == null ) {
            return null;
        }

        CarreiraResponse carreiraResponse = new CarreiraResponse();

        carreiraResponse.setUfConselho( estadoToEstadoResponse( carreira.getEstado() ) );
        carreiraResponse.setAreasAtendimento( areaAtendimentoListToAreaAtendimentoResponseList( carreira.getAreasAtendimento() ) );
        carreiraResponse.setId( carreira.getId() );
        carreiraResponse.setConselho( conselhoToConselhoResponse( carreira.getConselho() ) );
        carreiraResponse.setRegistroProfissional( carreira.getRegistroProfissional() );
        carreiraResponse.setNomeReferencia1( carreira.getNomeReferencia1() );
        carreiraResponse.setNomeReferencia2( carreira.getNomeReferencia2() );
        carreiraResponse.setTelefoneReferencia1( carreira.getTelefoneReferencia1() );
        carreiraResponse.setTelefoneReferencia2( carreira.getTelefoneReferencia2() );
        carreiraResponse.setTransporte( transporteToTransporteResponse( carreira.getTransporte() ) );

        return carreiraResponse;
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

    protected AreaAtendimentoResponse areaAtendimentoToAreaAtendimentoResponse(AreaAtendimento areaAtendimento) {
        if ( areaAtendimento == null ) {
            return null;
        }

        AreaAtendimentoResponse areaAtendimentoResponse = new AreaAtendimentoResponse();

        areaAtendimentoResponse.setId( areaAtendimento.getId() );
        areaAtendimentoResponse.setNome( areaAtendimento.getNome() );

        return areaAtendimentoResponse;
    }

    protected List<AreaAtendimentoResponse> areaAtendimentoListToAreaAtendimentoResponseList(List<AreaAtendimento> list) {
        if ( list == null ) {
            return null;
        }

        List<AreaAtendimentoResponse> list1 = new ArrayList<AreaAtendimentoResponse>( list.size() );
        for ( AreaAtendimento areaAtendimento : list ) {
            list1.add( areaAtendimentoToAreaAtendimentoResponse( areaAtendimento ) );
        }

        return list1;
    }

    protected ConselhoResponse conselhoToConselhoResponse(Conselho conselho) {
        if ( conselho == null ) {
            return null;
        }

        ConselhoResponse conselhoResponse = new ConselhoResponse();

        conselhoResponse.setId( conselho.getId() );
        conselhoResponse.setSigla( conselho.getSigla() );
        conselhoResponse.setDescricao( conselho.getDescricao() );

        return conselhoResponse;
    }

    protected TransporteResponse transporteToTransporteResponse(Transporte transporte) {
        if ( transporte == null ) {
            return null;
        }

        TransporteResponse transporteResponse = new TransporteResponse();

        transporteResponse.setId( transporte.getId() );
        transporteResponse.setTipo( transporte.getTipo() );

        return transporteResponse;
    }
}
