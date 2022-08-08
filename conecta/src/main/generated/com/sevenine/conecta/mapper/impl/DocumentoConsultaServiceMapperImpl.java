package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.mapper.DocumentoConsultaServiceMapper;
import com.sevenine.conecta.repository.data.SequenceCadastro;
import com.sevenine.conecta.service.data.response.DocumentoResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T09:19:59-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class DocumentoConsultaServiceMapperImpl implements DocumentoConsultaServiceMapper {

    @Override
    public DocumentoResponse fromEntityData(SequenceCadastro orElseThrow) {
        if ( orElseThrow == null ) {
            return null;
        }

        DocumentoResponse documentoResponse = new DocumentoResponse();

        documentoResponse.setId( orElseThrow.getId() );
        documentoResponse.setStatus( orElseThrow.getStatus() );
        documentoResponse.setDocumento( orElseThrow.getDocumento() );
        documentoResponse.setTipo( orElseThrow.getTipo() );
        documentoResponse.setModulo( orElseThrow.getModulo() );

        return documentoResponse;
    }
}
