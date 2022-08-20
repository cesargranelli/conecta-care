package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controller.data.response.ProfissionalResponse;
import com.sevenine.conecta.service.ConsultaProfissionalPorCpfService;
import com.sevenine.conecta.service.EstadoCivilService;
import com.sevenine.conecta.service.GeneroService;
import com.sevenine.conecta.service.TipoEmpresaService;
import com.sevenine.conecta.usecase.ConsultaProfissionalPorCpfUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConsultaProfissionalPorCpfUseCaseImpl implements ConsultaProfissionalPorCpfUseCase {

    private final ConsultaProfissionalPorCpfService consultaProfissionalPorCpfService;
    private final GeneroService generoService;
    private final TipoEmpresaService tipoEmpresaService;
    private final EstadoCivilService estadoCivilService;

    @Override
    public ProfissionalResponse executar(String numeroCpf) {
        ProfissionalResponse response = consultaProfissionalPorCpfService.consultar(numeroCpf);
        response.setGenero(generoService.consultar(response.getGenero().getId()));
        response.setTipoEmpresa(tipoEmpresaService.consultar(response.getTipoEmpresa().getId()));
        response.setEstadoCivil(estadoCivilService.consultar(response.getEstadoCivil().getId()));
        return response;
    }

}
