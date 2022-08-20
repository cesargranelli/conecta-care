package com.sevenine.conecta.usecase;

import com.sevenine.conecta.controller.data.response.ProfissionalResponse;
import com.sevenine.conecta.service.EstadoCivilService;
import com.sevenine.conecta.service.GeneroService;
import com.sevenine.conecta.service.ProfissionalService;
import com.sevenine.conecta.service.TipoEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfissionalUseCase {

    private final ProfissionalService profissionalService;
    private final GeneroService generoService;
    private final TipoEmpresaService tipoEmpresaService;
    private final EstadoCivilService estadoCivilService;

    public ProfissionalResponse consultar(Long idProfissional) {
        ProfissionalResponse response = profissionalService.consultar(idProfissional);
        response.setGenero(generoService.consultar(response.getGenero().getId()));
        response.setTipoEmpresa(tipoEmpresaService.consultar(response.getTipoEmpresa().getId()));
        response.setEstadoCivil(estadoCivilService.consultar(response.getEstadoCivil().getId()));
        return response;
    }

}
