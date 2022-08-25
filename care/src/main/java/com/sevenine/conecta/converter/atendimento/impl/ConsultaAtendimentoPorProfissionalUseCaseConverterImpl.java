package com.sevenine.conecta.converter.atendimento.impl;

import com.sevenine.conecta.converter.atendimento.ConsultaAtendimentoPorProfissionalUseCaseConverter;
import com.sevenine.conecta.services.data.response.*;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ConsultaAtendimentoPorProfissionalUseCaseConverterImpl implements ConsultaAtendimentoPorProfissionalUseCaseConverter {

    @Override
    public ProfissionalAtendimentoResponse toResponse(AtendimentoResponse atendimento,
                                                      PacienteResponse paciente,
                                                      AcompanhanteResponse acompanhante,
                                                      AtendimentoProfissionalResponse profissional) {
        ProfissionalAtendimentoResponse response = new ProfissionalAtendimentoResponse();

        response.setId(atendimento.getId());
        response.setTipo(atendimento.getTipo());
        response.setData(atendimento.getData());
        response.setHora(atendimento.getHora());
        response.setProtocolo(atendimento.getCodigoSeguranca());
        response.setObservacao(atendimento.getObservacao());
        response.setEndereco(atendimento.getEndereco());
        response.setGrupos(atendimento.getGrupos());
        response.setSituacoes(atendimento.getSituacoes());
        response.setAssinatura(atendimento.getAssinatura());

        AtendimentoPacienteResponse atendimentoPacienteResponse = new AtendimentoPacienteResponse();
        atendimentoPacienteResponse.setId(paciente.getId());
        atendimentoPacienteResponse.setNome(paciente.getNome());
        atendimentoPacienteResponse.setSobrenome(paciente.getSobrenome());
        atendimentoPacienteResponse.setCpf(paciente.getCpf());
        atendimentoPacienteResponse.setContato(paciente.getContato());
        response.setPaciente(atendimentoPacienteResponse);

        if (!isNull(acompanhante)) {
            AtendimentoAcompanhanteResponse atendimentoAcompanhanteResponse = new AtendimentoAcompanhanteResponse();
            atendimentoAcompanhanteResponse.setId(acompanhante.getId());
            atendimentoAcompanhanteResponse.setNomeCompleto(acompanhante.getNomeCompleto());
            atendimentoAcompanhanteResponse.setCpf(acompanhante.getCpf());
            atendimentoAcompanhanteResponse.setContato(acompanhante.getContato());
            response.setAcompanhante(atendimentoAcompanhanteResponse);
        }

        AtendimentoProfissionalResponse profissionalAtendimentoResponse = new AtendimentoProfissionalResponse();
        profissionalAtendimentoResponse.setId(profissional.getId());
        profissionalAtendimentoResponse.setNome(profissional.getNome());
        profissionalAtendimentoResponse.setSobrenome(profissional.getSobrenome());
        profissionalAtendimentoResponse.setCpf(profissional.getCpf());
        profissionalAtendimentoResponse.setContato(profissional.getContato());
        profissionalAtendimentoResponse.setFotoAssinatura(profissional.getFotoAssinatura());
        response.setProfissional(profissionalAtendimentoResponse);

        return response;
    }

}
