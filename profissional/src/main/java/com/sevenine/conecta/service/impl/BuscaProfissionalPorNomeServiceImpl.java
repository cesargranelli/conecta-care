package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.response.ProfissionalCpfResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.repository.ProfissionalPesquisaRepository;
import com.sevenine.conecta.repository.data.ProfissionalPesquisa;
import com.sevenine.conecta.service.BuscaProfissionalPorNomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class BuscaProfissionalPorNomeServiceImpl implements BuscaProfissionalPorNomeService {

    private final ProfissionalPesquisaRepository repository;

    @Override
    public List<ProfissionalCpfResponse> consultar(String nome) {

        List<ProfissionalPesquisa> listaProfissional = repository.findByNomeCompletoLike(nome).orElseThrow(() -> new InformacaoNaoEncontradaException("Não há nenhum profissional com esse nome.", HttpStatus.NO_CONTENT));

        List<ProfissionalCpfResponse> lista = new ArrayList<>();
        for (int i = 0; i < listaProfissional.size(); i++) {
            ProfissionalCpfResponse profissionalCpfResponse = new ProfissionalCpfResponse();
            profissionalCpfResponse.setCpf(listaProfissional.get(i).getCpf());
            profissionalCpfResponse.setNomeCompleto(listaProfissional.get(i).getNome() + " " + listaProfissional.get(i).getSobrenome());
            lista.add(profissionalCpfResponse);
        }

        return lista;
    }
}
