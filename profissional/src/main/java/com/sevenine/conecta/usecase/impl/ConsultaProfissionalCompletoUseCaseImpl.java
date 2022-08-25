package com.sevenine.conecta.usecase.impl;

import com.sevenine.conecta.controllers.data.response.ProfissionalCompletoResponse;
import com.sevenine.conecta.controllers.data.response.ProfissionalCpfResponse;
import com.sevenine.conecta.controllers.data.response.ProfissionalResponse;
import com.sevenine.conecta.exception.InformacaoNaoEncontradaException;
import com.sevenine.conecta.services.*;
import com.sevenine.conecta.usecase.ConsultaProfissionalCompletoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ConsultaProfissionalCompletoUseCaseImpl implements ConsultaProfissionalCompletoUseCase {

    private final ConsultaProfissionalPorCpfService consultaProfissionalPorCpfService;

    private final ConsultaEnderecoService consultaEnderecoService;

    private final ConsultaTelefoneService consultaTelefoneService;

    private final ConsultaContaService consultaContaService;

    private final ConsultaComplementoService consultaComplementoService;

    private final ConsultaExperienciaService consultaExperienciaService;

    private final ConsultaCarreiraService consultaCarreiraService;

    private final ConsultaEscolaridadeService consultaEscolaridadeService;

    @Override
    public ProfissionalCompletoResponse executar(Long cpf) {
        ProfissionalCompletoResponse profissionalCompleto = new ProfissionalCompletoResponse();

        ProfissionalResponse profissional = consultaProfissionalPorCpfService.consultar(cpf.toString());
        profissionalCompleto.setProfissional(profissional);

        Long profissionalId = profissional.getId();
        try {
            profissionalCompleto.setEndereco(consultaEnderecoService.consultar(profissionalId));
        } catch (InformacaoNaoEncontradaException e) {
            profissionalCompleto.setEndereco(null);
        }
        try {
            profissionalCompleto.setTelefone(consultaTelefoneService.consultar(profissionalId));
        } catch (InformacaoNaoEncontradaException e) {
            profissionalCompleto.setTelefone(null);
        }
        try {
            profissionalCompleto.setConta(consultaContaService.consultar(profissionalId));
        } catch (InformacaoNaoEncontradaException e) {
            profissionalCompleto.setConta(null);
        }
        try {
            profissionalCompleto.setComplemento(consultaComplementoService.consultar(profissionalId));
        } catch (InformacaoNaoEncontradaException e) {
            profissionalCompleto.setComplemento(null);
        }
        try {
            profissionalCompleto.setExperiencia(consultaExperienciaService.consultar(profissionalId));
        } catch (InformacaoNaoEncontradaException e) {
            profissionalCompleto.setExperiencia(null);
        }
        try {
            profissionalCompleto.setCarreira(consultaCarreiraService.consultar(profissionalId));
        } catch (InformacaoNaoEncontradaException e) {
            profissionalCompleto.setCarreira(null);
        }
        try {
            profissionalCompleto.setEscolaridade(consultaEscolaridadeService.consultar(profissionalId));
        } catch (InformacaoNaoEncontradaException e) {
            profissionalCompleto.setEscolaridade(null);
        }


        return profissionalCompleto;
    }

}
