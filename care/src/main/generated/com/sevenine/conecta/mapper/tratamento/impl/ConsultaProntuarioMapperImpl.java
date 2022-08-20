package com.sevenine.conecta.mapper.tratamento.impl;

import com.sevenine.conecta.controller.data.response.tratamento.ProntuarioAtendimentoResponse;
import com.sevenine.conecta.controller.data.response.tratamento.ProntuarioResponse;
import com.sevenine.conecta.controller.data.response.tratamento.ProntuarioTratamentoResponse;
import com.sevenine.conecta.mapper.tratamento.ConsultaProntuarioMapper;
import com.sevenine.conecta.service.data.response.AtendimentoDetalheResponse;
import com.sevenine.conecta.service.data.response.AtendimentoProfissionalResponse;
import com.sevenine.conecta.service.data.response.EspecialidadeResponse;
import com.sevenine.conecta.service.data.response.PacienteProntuarioResponse;
import com.sevenine.conecta.service.data.response.PacienteResponse;
import com.sevenine.conecta.service.data.response.ProntuarioProfissionalResponse;
import com.sevenine.conecta.service.data.response.TratamentoResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T14:36:57-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaProntuarioMapperImpl implements ConsultaProntuarioMapper {

    @Override
    public ProntuarioResponse fromServiceResponse(PacienteResponse pacienteResponse, List<TratamentoResponse> tratamentosResponse) {
        if ( pacienteResponse == null && tratamentosResponse == null ) {
            return null;
        }

        ProntuarioResponse prontuarioResponse = new ProntuarioResponse();

        if ( pacienteResponse != null ) {
            prontuarioResponse.setPaciente( pacienteResponseToPacienteProntuarioResponse( pacienteResponse ) );
        }
        if ( tratamentosResponse != null ) {
            prontuarioResponse.setTratamentos( tratamentoResponseListToProntuarioTratamentoResponseList( tratamentosResponse ) );
        }

        return prontuarioResponse;
    }

    protected PacienteProntuarioResponse pacienteResponseToPacienteProntuarioResponse(PacienteResponse pacienteResponse) {
        if ( pacienteResponse == null ) {
            return null;
        }

        PacienteProntuarioResponse pacienteProntuarioResponse = new PacienteProntuarioResponse();

        pacienteProntuarioResponse.setId( pacienteResponse.getId() );
        pacienteProntuarioResponse.setNome( pacienteResponse.getNome() );
        pacienteProntuarioResponse.setSobrenome( pacienteResponse.getSobrenome() );
        pacienteProntuarioResponse.setCpf( pacienteResponse.getCpf() );
        pacienteProntuarioResponse.setDataNascimento( pacienteResponse.getDataNascimento() );
        pacienteProntuarioResponse.setGenero( pacienteResponse.getGenero() );
        pacienteProntuarioResponse.setEstadoCivil( pacienteResponse.getEstadoCivil() );
        pacienteProntuarioResponse.setContato( pacienteResponse.getContato() );

        return pacienteProntuarioResponse;
    }

    protected ProntuarioProfissionalResponse atendimentoProfissionalResponseToProntuarioProfissionalResponse(AtendimentoProfissionalResponse atendimentoProfissionalResponse) {
        if ( atendimentoProfissionalResponse == null ) {
            return null;
        }

        ProntuarioProfissionalResponse prontuarioProfissionalResponse = new ProntuarioProfissionalResponse();

        prontuarioProfissionalResponse.setId( atendimentoProfissionalResponse.getId() );
        prontuarioProfissionalResponse.setCpf( atendimentoProfissionalResponse.getCpf() );
        prontuarioProfissionalResponse.setNome( atendimentoProfissionalResponse.getNome() );
        prontuarioProfissionalResponse.setSobrenome( atendimentoProfissionalResponse.getSobrenome() );
        prontuarioProfissionalResponse.setConselho( atendimentoProfissionalResponse.getConselho() );
        prontuarioProfissionalResponse.setRegistro( atendimentoProfissionalResponse.getRegistro() );
        prontuarioProfissionalResponse.setCelular( atendimentoProfissionalResponse.getCelular() );
        List<EspecialidadeResponse> list = atendimentoProfissionalResponse.getEspecialidades();
        if ( list != null ) {
            prontuarioProfissionalResponse.setEspecialidades( new ArrayList<EspecialidadeResponse>( list ) );
        }

        return prontuarioProfissionalResponse;
    }

    protected ProntuarioAtendimentoResponse atendimentoDetalheResponseToProntuarioAtendimentoResponse(AtendimentoDetalheResponse atendimentoDetalheResponse) {
        if ( atendimentoDetalheResponse == null ) {
            return null;
        }

        ProntuarioAtendimentoResponse prontuarioAtendimentoResponse = new ProntuarioAtendimentoResponse();

        prontuarioAtendimentoResponse.setId( atendimentoDetalheResponse.getId() );
        prontuarioAtendimentoResponse.setData( atendimentoDetalheResponse.getData() );
        prontuarioAtendimentoResponse.setHora( atendimentoDetalheResponse.getHora() );

        return prontuarioAtendimentoResponse;
    }

    protected List<ProntuarioAtendimentoResponse> atendimentoDetalheResponseListToProntuarioAtendimentoResponseList(List<AtendimentoDetalheResponse> list) {
        if ( list == null ) {
            return null;
        }

        List<ProntuarioAtendimentoResponse> list1 = new ArrayList<ProntuarioAtendimentoResponse>( list.size() );
        for ( AtendimentoDetalheResponse atendimentoDetalheResponse : list ) {
            list1.add( atendimentoDetalheResponseToProntuarioAtendimentoResponse( atendimentoDetalheResponse ) );
        }

        return list1;
    }

    protected ProntuarioTratamentoResponse tratamentoResponseToProntuarioTratamentoResponse(TratamentoResponse tratamentoResponse) {
        if ( tratamentoResponse == null ) {
            return null;
        }

        ProntuarioTratamentoResponse prontuarioTratamentoResponse = new ProntuarioTratamentoResponse();

        prontuarioTratamentoResponse.setId( tratamentoResponse.getId() );
        prontuarioTratamentoResponse.setDescricao( tratamentoResponse.getDescricao() );
        prontuarioTratamentoResponse.setProfissional( atendimentoProfissionalResponseToProntuarioProfissionalResponse( tratamentoResponse.getProfissional() ) );
        prontuarioTratamentoResponse.setAtendimentos( atendimentoDetalheResponseListToProntuarioAtendimentoResponseList( tratamentoResponse.getAtendimentos() ) );

        return prontuarioTratamentoResponse;
    }

    protected List<ProntuarioTratamentoResponse> tratamentoResponseListToProntuarioTratamentoResponseList(List<TratamentoResponse> list) {
        if ( list == null ) {
            return null;
        }

        List<ProntuarioTratamentoResponse> list1 = new ArrayList<ProntuarioTratamentoResponse>( list.size() );
        for ( TratamentoResponse tratamentoResponse : list ) {
            list1.add( tratamentoResponseToProntuarioTratamentoResponse( tratamentoResponse ) );
        }

        return list1;
    }
}
