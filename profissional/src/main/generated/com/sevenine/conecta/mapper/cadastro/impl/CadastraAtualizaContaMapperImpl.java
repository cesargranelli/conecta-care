package com.sevenine.conecta.mapper.cadastro.impl;

import com.sevenine.conecta.controller.data.request.BancoRequest;
import com.sevenine.conecta.controller.data.request.ContaRequest;
import com.sevenine.conecta.controller.data.request.TipoContaRequest;
import com.sevenine.conecta.controller.data.response.CadastraAtualizaContaResponse;
import com.sevenine.conecta.mapper.cadastro.CadastraAtualizaContaMapper;
import com.sevenine.conecta.repository.data.Banco;
import com.sevenine.conecta.repository.data.Conta;
import com.sevenine.conecta.repository.data.Profissional;
import com.sevenine.conecta.repository.data.TipoConta;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-20T13:19:50-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class CadastraAtualizaContaMapperImpl implements CadastraAtualizaContaMapper {

    @Override
    public Conta toEntityData(ContaRequest request) {
        if ( request == null ) {
            return null;
        }

        Conta conta = new Conta();

        conta.setTipoConta( tipoContaRequestToTipoConta( request.getTipo() ) );
        conta.setProfissional( contaRequestToProfissional( request ) );
        conta.setId( request.getId() );
        conta.setAgencia( request.getAgencia() );
        conta.setNumero( request.getNumero() );
        conta.setDigito( request.getDigito() );
        conta.setChavePixPrimaria( request.getChavePixPrimaria() );
        conta.setChavePixSecundaria( request.getChavePixSecundaria() );
        conta.setBanco( bancoRequestToBanco( request.getBanco() ) );

        return conta;
    }

    @Override
    public CadastraAtualizaContaResponse fromEntityData(Conta conta) {
        if ( conta == null ) {
            return null;
        }

        CadastraAtualizaContaResponse cadastraAtualizaContaResponse = new CadastraAtualizaContaResponse();

        cadastraAtualizaContaResponse.setProfissionalId( contaProfissionalId( conta ) );

        return cadastraAtualizaContaResponse;
    }

    protected TipoConta tipoContaRequestToTipoConta(TipoContaRequest tipoContaRequest) {
        if ( tipoContaRequest == null ) {
            return null;
        }

        TipoConta tipoConta = new TipoConta();

        tipoConta.setId( tipoContaRequest.getId() );
        tipoConta.setCodigo( tipoContaRequest.getCodigo() );
        tipoConta.setDescricao( tipoContaRequest.getDescricao() );

        return tipoConta;
    }

    protected Profissional contaRequestToProfissional(ContaRequest contaRequest) {
        if ( contaRequest == null ) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setId( contaRequest.getProprietarioId() );

        return profissional;
    }

    protected Banco bancoRequestToBanco(BancoRequest bancoRequest) {
        if ( bancoRequest == null ) {
            return null;
        }

        Banco banco = new Banco();

        banco.setId( bancoRequest.getId() );
        banco.setCodigo( bancoRequest.getCodigo() );
        banco.setDescricao( bancoRequest.getDescricao() );

        return banco;
    }

    private Long contaProfissionalId(Conta conta) {
        if ( conta == null ) {
            return null;
        }
        Profissional profissional = conta.getProfissional();
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
