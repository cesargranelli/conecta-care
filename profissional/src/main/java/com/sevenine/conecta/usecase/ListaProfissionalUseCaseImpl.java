package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.ListaProfissionalResponse;
import com.sevenine.conecta.service.ListaProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ListaProfissionalUseCaseImpl implements ListaProfissionalUseCase {

    private final ListaProfissionalService service;

    @Override
    public List<ListaProfissionalResponse> executar(List<Long> profissionaisIds) {
        return service.listar(profissionaisIds);
    }

}
