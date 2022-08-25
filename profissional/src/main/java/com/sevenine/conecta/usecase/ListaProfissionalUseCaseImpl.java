package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controllers.data.response.ListaProfissionalResponse;
import com.sevenine.conecta.services.ListaProfissionalService;
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
