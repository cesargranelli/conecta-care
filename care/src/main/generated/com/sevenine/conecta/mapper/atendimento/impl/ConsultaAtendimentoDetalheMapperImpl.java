package com.sevenine.conecta.mapper.atendimento.impl;

import com.sevenine.conecta.controller.data.response.atendimento.AtendimentoDetalheProfissionalResponse;
import com.sevenine.conecta.controller.data.response.atendimento.ConsultaAtendimentoDetalheResponse;
import com.sevenine.conecta.mapper.atendimento.ConsultaAtendimentoDetalheMapper;
import com.sevenine.conecta.service.data.response.AcompanhanteResponse;
import com.sevenine.conecta.service.data.response.AtendimentoDetalheResponse;
import com.sevenine.conecta.service.data.response.AtendimentoProfissionalResponse;
import com.sevenine.conecta.service.data.response.GrupoResponse;
import com.sevenine.conecta.service.data.response.PlantonistaResponse;
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
public class ConsultaAtendimentoDetalheMapperImpl implements ConsultaAtendimentoDetalheMapper {

    @Override
    public ConsultaAtendimentoDetalheResponse fromAtendimentoAndProfissional(AtendimentoDetalheResponse atendimentoResponse, PlantonistaResponse plantonistaResponse, AcompanhanteResponse acompanhanteResponse, AtendimentoProfissionalResponse atendimentoProfissionalResponse) {
        if ( atendimentoResponse == null && plantonistaResponse == null && acompanhanteResponse == null && atendimentoProfissionalResponse == null ) {
            return null;
        }

        ConsultaAtendimentoDetalheResponse consultaAtendimentoDetalheResponse = new ConsultaAtendimentoDetalheResponse();

        if ( atendimentoResponse != null ) {
            consultaAtendimentoDetalheResponse.setId( atendimentoResponse.getId() );
            consultaAtendimentoDetalheResponse.setProtocolo( atendimentoResponse.getProtocolo() );
            consultaAtendimentoDetalheResponse.setObservacao( atendimentoResponse.getObservacao() );
            consultaAtendimentoDetalheResponse.setEndereco( atendimentoResponse.getEndereco() );
            consultaAtendimentoDetalheResponse.setRecorrencia( atendimentoResponse.getRecorrencia() );
            consultaAtendimentoDetalheResponse.setValorHomeCare( atendimentoResponse.getValorHomeCare() );
            consultaAtendimentoDetalheResponse.setValorProfissional( atendimentoResponse.getValorProfissional() );
            consultaAtendimentoDetalheResponse.setValorPaciente( atendimentoResponse.getValorPaciente() );
            consultaAtendimentoDetalheResponse.setValorAjudaCusto( atendimentoResponse.getValorAjudaCusto() );
            List<GrupoResponse> list = atendimentoResponse.getGrupos();
            if ( list != null ) {
                consultaAtendimentoDetalheResponse.setGrupos( new ArrayList<GrupoResponse>( list ) );
            }
            consultaAtendimentoDetalheResponse.setTipoAtendimento( atendimentoResponse.getTipoAtendimento() );
        }
        if ( plantonistaResponse != null ) {
            consultaAtendimentoDetalheResponse.setPlantonista( plantonistaResponse );
        }
        if ( acompanhanteResponse != null ) {
            consultaAtendimentoDetalheResponse.setAcompanhante( acompanhanteResponse );
        }
        if ( atendimentoProfissionalResponse != null ) {
            consultaAtendimentoDetalheResponse.setProfissional( atendimentoProfissionalResponseToAtendimentoDetalheProfissionalResponse( atendimentoProfissionalResponse ) );
        }
        consultaAtendimentoDetalheResponse.setDataHora( atendimentoResponse.getData().atTime(atendimentoResponse.getHora()) );

        return consultaAtendimentoDetalheResponse;
    }

    protected AtendimentoDetalheProfissionalResponse atendimentoProfissionalResponseToAtendimentoDetalheProfissionalResponse(AtendimentoProfissionalResponse atendimentoProfissionalResponse) {
        if ( atendimentoProfissionalResponse == null ) {
            return null;
        }

        AtendimentoDetalheProfissionalResponse atendimentoDetalheProfissionalResponse = new AtendimentoDetalheProfissionalResponse();

        atendimentoDetalheProfissionalResponse.setDocumento( atendimentoProfissionalResponse.getCpf() );

        atendimentoDetalheProfissionalResponse.setNomeCompleto( atendimentoProfissionalResponse.getNome().concat(" ").concat(atendimentoProfissionalResponse.getSobrenome()) );

        return atendimentoDetalheProfissionalResponse;
    }
}
