package com.sevenine.conecta.mapper.consulta.impl;

import com.sevenine.conecta.controller.data.response.EscolaridadeResponse;
import com.sevenine.conecta.controller.data.response.InstrucaoResponse;
import com.sevenine.conecta.mapper.consulta.ConsultaEscolaridadeMapper;
import com.sevenine.conecta.repository.data.Escolaridade;
import com.sevenine.conecta.repository.data.Instrucao;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaEscolaridadeMapperImpl implements ConsultaEscolaridadeMapper {

    @Override
    public EscolaridadeResponse fromEntityData(Escolaridade escolaridade) {
        if ( escolaridade == null ) {
            return null;
        }

        EscolaridadeResponse escolaridadeResponse = new EscolaridadeResponse();

        escolaridadeResponse.setId( escolaridade.getId() );
        escolaridadeResponse.setInstrucao( instrucaoToInstrucaoResponse( escolaridade.getInstrucao() ) );

        escolaridadeResponse.setInstituicaoEnsino( java.util.Arrays.asList(org.springframework.util.StringUtils.commaDelimitedListToStringArray(escolaridade.getInstituicaoEnsino().replaceAll("[\\[\\]\"]", ""))) );
        escolaridadeResponse.setAnoConclusao( java.util.Arrays.asList(org.springframework.util.StringUtils.commaDelimitedListToStringArray(escolaridade.getAnoConclusao().replaceAll("[\\[\\]\"]", ""))) );

        return escolaridadeResponse;
    }

    protected InstrucaoResponse instrucaoToInstrucaoResponse(Instrucao instrucao) {
        if ( instrucao == null ) {
            return null;
        }

        InstrucaoResponse instrucaoResponse = new InstrucaoResponse();

        instrucaoResponse.setId( instrucao.getId() );
        instrucaoResponse.setGrau( instrucao.getGrau() );

        return instrucaoResponse;
    }
}
