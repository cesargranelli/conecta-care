package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.adapter.controller.data.response.ProfissionalFiltroDadosSmsResponse;
import com.sevenine.conecta.services.ProfissionalFiltroDadosSmsService;
import com.sevenine.conecta.usecase.ProfissionalFiltroDadosSmsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProfissionalFiltroDadosSmsUseCaseImpl implements ProfissionalFiltroDadosSmsUseCase {

    private final ProfissionalFiltroDadosSmsService filtroDadosSmsService;

    @Override
    public List<ProfissionalFiltroDadosSmsResponse> executar(List<Long> idsEspecialidades, Long idEstado) {
        return filtroDadosSmsService.consultar(idsEspecialidades, idEstado);
    }

}
