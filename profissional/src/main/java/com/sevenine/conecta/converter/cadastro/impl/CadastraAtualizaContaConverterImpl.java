package com.sevenine.conecta.converter.cadastro.impl;

import com.sevenine.conecta.controller.data.request.BancoRequest;
import com.sevenine.conecta.controller.data.request.ContaRequest;
import com.sevenine.conecta.controller.data.request.TipoContaRequest;
import com.sevenine.conecta.converter.cadastro.CadastraAtualizaContaConverter;
import com.sevenine.conecta.repository.data.Banco;
import com.sevenine.conecta.repository.data.Conta;
import com.sevenine.conecta.repository.data.Profissional;
import com.sevenine.conecta.repository.data.TipoConta;
import org.springframework.stereotype.Component;

@Component
public class CadastraAtualizaContaConverterImpl implements CadastraAtualizaContaConverter {
    @Override
    public Conta toEntityData(ContaRequest request) {
        if (request == null) {
            return null;
        }

        Conta conta = new Conta();

        conta.setId(request.getId());
        conta.setTipoConta(tipoContaRequestToTipoConta(request.getTipo()));
        conta.setProfissional(contaRequestToProfissional(request));
        conta.setAgencia(request.getAgencia());
        conta.setNumero(request.getNumero());
        conta.setDigito(request.getDigito());
        conta.setChavePixPrimaria(request.getChavePixPrimaria());
        conta.setChavePixSecundaria(request.getChavePixSecundaria());
        conta.setBanco(bancoRequestToBanco(request.getBanco()));

        return conta;
    }


    protected TipoConta tipoContaRequestToTipoConta(TipoContaRequest tipoContaRequest) {
        if (tipoContaRequest == null) {
            return null;
        }

        TipoConta tipoConta = new TipoConta();

        tipoConta.setId(tipoContaRequest.getId());
        tipoConta.setCodigo(tipoContaRequest.getCodigo());
        tipoConta.setDescricao(tipoContaRequest.getDescricao());

        return tipoConta;
    }

    protected Profissional contaRequestToProfissional(ContaRequest contaRequest) {
        if (contaRequest == null) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setId(contaRequest.getProprietarioId());

        return profissional;
    }

    protected Banco bancoRequestToBanco(BancoRequest bancoRequest) {
        if (bancoRequest == null) {
            return null;
        }

        Banco banco = new Banco();

        banco.setId(bancoRequest.getId());
        banco.setCodigo(bancoRequest.getCodigo());
        banco.setDescricao(bancoRequest.getDescricao());

        return banco;
    }

    private Long contaProfissionalId(Conta conta) {
        if (conta == null) {
            return null;
        }
        Profissional profissional = conta.getProfissional();
        if (profissional == null) {
            return null;
        }
        Long id = profissional.getId();
        return id;
    }

    protected void tipoContaRequestToTipoConta1(TipoContaRequest tipoContaRequest, TipoConta mappingTarget) {
        if (tipoContaRequest == null) {
            return;
        }

        mappingTarget.setId(tipoContaRequest.getId());
        mappingTarget.setCodigo(tipoContaRequest.getCodigo());
        mappingTarget.setDescricao(tipoContaRequest.getDescricao());
    }

    protected void bancoRequestToBanco1(BancoRequest bancoRequest, Banco mappingTarget) {
        if (bancoRequest == null) {
            return;
        }

        mappingTarget.setId(bancoRequest.getId());
        mappingTarget.setCodigo(bancoRequest.getCodigo());
        mappingTarget.setDescricao(bancoRequest.getDescricao());
    }


}

