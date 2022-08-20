package com.sevenine.conecta.mapper.consulta.impl;

import com.sevenine.conecta.controller.data.response.BancoResponse;
import com.sevenine.conecta.controller.data.response.ContaResponse;
import com.sevenine.conecta.controller.data.response.TipoContaResponse;
import com.sevenine.conecta.mapper.consulta.ConsultaContaMapper;
import com.sevenine.conecta.repository.data.Banco;
import com.sevenine.conecta.repository.data.Conta;
import com.sevenine.conecta.repository.data.TipoConta;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:51-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConsultaContaMapperImpl implements ConsultaContaMapper {

    @Override
    public ContaResponse fromEntityData(Conta conta) {
        if ( conta == null ) {
            return null;
        }

        ContaResponse contaResponse = new ContaResponse();

        contaResponse.setTipo( tipoContaToTipoContaResponse( conta.getTipoConta() ) );
        contaResponse.setId( conta.getId() );
        contaResponse.setBanco( bancoToBancoResponse( conta.getBanco() ) );
        contaResponse.setAgencia( conta.getAgencia() );
        contaResponse.setNumero( conta.getNumero() );
        contaResponse.setDigito( conta.getDigito() );
        contaResponse.setChavePixPrimaria( conta.getChavePixPrimaria() );
        contaResponse.setChavePixSecundaria( conta.getChavePixSecundaria() );

        return contaResponse;
    }

    protected TipoContaResponse tipoContaToTipoContaResponse(TipoConta tipoConta) {
        if ( tipoConta == null ) {
            return null;
        }

        TipoContaResponse tipoContaResponse = new TipoContaResponse();

        tipoContaResponse.setId( tipoConta.getId() );
        tipoContaResponse.setCodigo( tipoConta.getCodigo() );
        tipoContaResponse.setDescricao( tipoConta.getDescricao() );

        return tipoContaResponse;
    }

    protected BancoResponse bancoToBancoResponse(Banco banco) {
        if ( banco == null ) {
            return null;
        }

        BancoResponse bancoResponse = new BancoResponse();

        bancoResponse.setId( banco.getId() );
        bancoResponse.setCodigo( banco.getCodigo() );
        bancoResponse.setDescricao( banco.getDescricao() );

        return bancoResponse;
    }
}
