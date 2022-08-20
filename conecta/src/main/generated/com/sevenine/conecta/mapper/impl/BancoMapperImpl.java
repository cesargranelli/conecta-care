package com.sevenine.conecta.mapper.impl;

import com.sevenine.conecta.controller.data.response.ConsultaBancoResponse;
import com.sevenine.conecta.mapper.BancoMapper;
import com.sevenine.conecta.repository.data.Banco;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-19T21:51:16-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class BancoMapperImpl implements BancoMapper {

    @Override
    public List<ConsultaBancoResponse> fromEntityData(List<Banco> bancos) {
        if ( bancos == null ) {
            return null;
        }

        List<ConsultaBancoResponse> list = new ArrayList<ConsultaBancoResponse>( bancos.size() );
        for ( Banco banco : bancos ) {
            list.add( bancoToConsultaBancoResponse( banco ) );
        }

        return list;
    }

    protected ConsultaBancoResponse bancoToConsultaBancoResponse(Banco banco) {
        if ( banco == null ) {
            return null;
        }

        ConsultaBancoResponse consultaBancoResponse = new ConsultaBancoResponse();

        if ( banco.getId() != null ) {
            consultaBancoResponse.setId( banco.getId().intValue() );
        }
        consultaBancoResponse.setCodigo( banco.getCodigo() );
        consultaBancoResponse.setDescricao( banco.getDescricao() );

        return consultaBancoResponse;
    }
}
