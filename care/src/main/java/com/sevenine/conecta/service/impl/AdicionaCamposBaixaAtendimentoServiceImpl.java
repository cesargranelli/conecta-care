package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.atendimento.GrupoBaixaRequest;
import com.sevenine.conecta.repository.AtendimentoCampoBaixaRepository;
import com.sevenine.conecta.repository.data.AtendimentoCampoBaixa;
import com.sevenine.conecta.service.AdicionaCamposBaixaAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdicionaCamposBaixaAtendimentoServiceImpl implements AdicionaCamposBaixaAtendimentoService {

    private List<AtendimentoCampoBaixa> atendimentoCampoBaixas;

    private final AtendimentoCampoBaixaRepository repository;

    @Override
    public void adicionar(List<GrupoBaixaRequest> requestList, List<String> fotos, Long atendimentoId) {
        extraiCampos(requestList, fotos, atendimentoId);
        repository.saveAll(atendimentoCampoBaixas);
    }

    private void extraiCampos(List<GrupoBaixaRequest> grupoBaixaRequest, List<String> fotos, Long atendimentoId) {
        atendimentoCampoBaixas = new ArrayList<>();

        grupoBaixaRequest.forEach(grupo ->
                grupo.getSubgrupos().forEach(subgrupo ->
                        subgrupo.getCampos().forEach(campo -> {
                            AtendimentoCampoBaixa atendimentoCampoBaixa = new AtendimentoCampoBaixa();
                            atendimentoCampoBaixa.setAtendimentoId(atendimentoId);
                            atendimentoCampoBaixa.setCampoId(campo.getId());
                            atendimentoCampoBaixa.setTexto(campo.getValor());
                            atendimentoCampoBaixas.add(atendimentoCampoBaixa);
                        })));

        fotos.forEach(foto -> {
            AtendimentoCampoBaixa atendimentoCampoBaixa = new AtendimentoCampoBaixa();
            atendimentoCampoBaixa.setAtendimentoId(atendimentoId);
            atendimentoCampoBaixa.setCampoId(Long.valueOf("-1"));
            atendimentoCampoBaixa.setTexto(foto);
            atendimentoCampoBaixas.add(atendimentoCampoBaixa);
        });
    }

}
