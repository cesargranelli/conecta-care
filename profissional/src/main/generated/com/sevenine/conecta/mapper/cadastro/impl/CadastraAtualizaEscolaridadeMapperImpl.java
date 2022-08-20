package com.sevenine.conecta.mapper.cadastro.impl;

import com.sevenine.conecta.controller.data.request.EscolaridadeRequest;
import com.sevenine.conecta.controller.data.request.InstrucaoRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaEscolaridadeResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaEscolaridadeMapper;
import com.sevenine.conecta.repository.data.Escolaridade;
import com.sevenine.conecta.repository.data.Instrucao;
import com.sevenine.conecta.repository.data.Profissional;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class CadastraAtualizaEscolaridadeMapperImpl implements CadastraAtualizaEscolaridadeMapper {

    @Override
    public Escolaridade toEntityData(EscolaridadeRequest request) {
        if ( request == null ) {
            return null;
        }

        Escolaridade escolaridade = new Escolaridade();

        escolaridade.setInstrucao( instrucaoRequestToInstrucao( request.getInstrucao() ) );
        escolaridade.setProfissional( escolaridadeRequestToProfissional( request ) );

        escolaridade.setInstituicaoEnsino( request.getInstituicaoEnsino().stream().map(String::toString).collect(java.util.stream.Collectors.joining("\",\"", "[\"", "\"]")) );
        escolaridade.setAnoConclusao( request.getAnoConclusao().stream().map(String::toString).collect(java.util.stream.Collectors.joining("\",\"", "[\"", "\"]")) );

        return escolaridade;
    }

    @Override
    public CadastraAtualizaEscolaridadeResponse fromEntityData(Escolaridade escolaridade) {
        if ( escolaridade == null ) {
            return null;
        }

        CadastraAtualizaEscolaridadeResponse cadastraAtualizaEscolaridadeResponse = new CadastraAtualizaEscolaridadeResponse();

        cadastraAtualizaEscolaridadeResponse.setProfissionalId( escolaridadeProfissionalId( escolaridade ) );

        return cadastraAtualizaEscolaridadeResponse;
    }

    @Override
    public void updateEscolaridade(EscolaridadeRequest request, Escolaridade escolaridade) {
        if ( request == null ) {
            return;
        }

        escolaridade.setInstituicaoEnsino( request.getInstituicaoEnsino().stream().map(String::toString).collect(java.util.stream.Collectors.joining("\",\"", "[\"", "\"]")) );
        escolaridade.setAnoConclusao( request.getAnoConclusao().stream().map(String::toString).collect(java.util.stream.Collectors.joining("\",\"", "[\"", "\"]")) );
    }

    protected Instrucao instrucaoRequestToInstrucao(InstrucaoRequest instrucaoRequest) {
        if ( instrucaoRequest == null ) {
            return null;
        }

        Instrucao instrucao = new Instrucao();

        instrucao.setGrau( instrucaoRequest.getGrau() );

        return instrucao;
    }

    protected Profissional escolaridadeRequestToProfissional(EscolaridadeRequest escolaridadeRequest) {
        if ( escolaridadeRequest == null ) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setId( escolaridadeRequest.getProprietarioId() );

        return profissional;
    }

    private Long escolaridadeProfissionalId(Escolaridade escolaridade) {
        if ( escolaridade == null ) {
            return null;
        }
        Profissional profissional = escolaridade.getProfissional();
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
