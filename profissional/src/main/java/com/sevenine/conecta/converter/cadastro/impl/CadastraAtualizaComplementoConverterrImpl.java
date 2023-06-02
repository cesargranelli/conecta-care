package com.sevenine.conecta.converter.cadastro.impl;

import com.sevenine.conecta.adapter.controller.data.request.ComplementoRequest;
import com.sevenine.conecta.converter.cadastro.CadastraAtualizaComplementoConverter;
import com.sevenine.conecta.repository.data.CategoriaCnh;
import com.sevenine.conecta.repository.data.Complemento;
import com.sevenine.conecta.repository.data.Profissional;
import org.springframework.stereotype.Component;

@Component
public class CadastraAtualizaComplementoConverterrImpl implements CadastraAtualizaComplementoConverter {

    @Override
    public Complemento toEntityData(ComplementoRequest request) {
        if (request == null) {
            return null;
        }

        Complemento complemento = new Complemento();

        complemento.setProfissional(complementoRequestToProfissional(request));
        complemento.setFotoCnhFrente(request.getFotoCNHFrente());
        complemento.setFotoCnhVerso(request.getFotoCNHVerso());
        complemento.setId(request.getId());
        complemento.setTituloEleitoral(request.getTituloEleitoral());
        complemento.setZonaEleitoral(request.getZonaEleitoral());
        complemento.setSecaoEleitoral(request.getSecaoEleitoral());
        complemento.setNumeroHabilitacao(request.getNumeroHabilitacao());
        complemento.setDataValidadeHabilitacao(request.getDataValidadeHabilitacao());
        complemento.setNumeroReservista(request.getNumeroReservista());
        complemento.setNomeMae(request.getNomeMae());
        complemento.setProfissaoMae(request.getProfissaoMae());
        complemento.setNomePai(request.getNomePai());
        complemento.setProfissaoPai(request.getProfissaoPai());
        complemento.setNomeConjuge(request.getNomeConjuge());
        complemento.setProfissaoConjuge(request.getProfissaoConjuge());
        complemento.setCarteiraVacinacao(request.isCarteiraVacinacao());

        if (request.getCategoriaCNH() != null) {
            complemento.setCategoriaCnh(complementoRequestToCategoriaCnh(request));
        }

        return complemento;
    }

    protected Profissional complementoRequestToProfissional(ComplementoRequest complementoRequest) {
        if (complementoRequest == null) {
            return null;
        }

        Profissional profissional = new Profissional();

        profissional.setId(complementoRequest.getProprietarioId());

        return profissional;
    }

    protected CategoriaCnh complementoRequestToCategoriaCnh(ComplementoRequest complementoRequest) {
        if (complementoRequest == null) {
            return null;
        }

        CategoriaCnh categoriaCnh = new CategoriaCnh();

        categoriaCnh.setId(complementoRequest.getCategoriaCNH());

        return categoriaCnh;
    }

    private Long complementoProfissionalId(Complemento complemento) {
        if (complemento == null) {
            return null;
        }
        Profissional profissional = complemento.getProfissional();
        if (profissional == null) {
            return null;
        }
        Long id = profissional.getId();
        return id;
    }
}
