package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.response.ProfissionalResponse;
import com.sevenine.conecta.service.ProfissionalFiltroEspecialidadeService;
import com.sevenine.conecta.usecase.ProfissionalFiltroEspecialidadeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProfissionalFiltroEspecialidadeUseCaseImpl implements ProfissionalFiltroEspecialidadeUseCase {

    private final ProfissionalFiltroEspecialidadeService filtroEspecialidadeService;

    @Override
    public List<ProfissionalResponse> executar(List<Long> idsEspecialidades) {
        return filtroEspecialidadeService.consultar(idsEspecialidades);
    }

}
