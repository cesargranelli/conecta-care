package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.response.ProfissionalCpfResponse;
import com.sevenine.conecta.service.BuscaProfissionalPorNomeService;
import com.sevenine.conecta.usecase.ConsultaProfissionalPorNomeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ConsultaProfissionalPorNomeUseCaseImpl implements ConsultaProfissionalPorNomeUseCase {

    private final BuscaProfissionalPorNomeService service;

    @Override
    public List<ProfissionalCpfResponse> executar(String nome) {
        String nomePorcentagem = "%" + nome + "%";
        return service.consultar(nomePorcentagem);
    }

}
