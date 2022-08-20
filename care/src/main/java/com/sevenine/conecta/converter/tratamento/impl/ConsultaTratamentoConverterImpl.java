package com.sevenine.conecta.converter.tratamento.impl;

import com.sevenine.conecta.controller.data.response.tratamento.*;
import com.sevenine.conecta.converter.tratamento.ConsultaTratamentoConverter;
import com.sevenine.conecta.service.data.response.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ConsultaTratamentoConverterImpl implements ConsultaTratamentoConverter {

    @Override
    public ConsultaTratamentoResponse fromTratamentoResponseToConsultaTratamentoResponse(TratamentoResponse tratamentoResponse) {
        ConsultaTratamentoResponse consultaTratamentoResponse = new ConsultaTratamentoResponse();
        consultaTratamentoResponse.setId(tratamentoResponse.getId());
        consultaTratamentoResponse.setDescricao(tratamentoResponse.getDescricao());
        consultaTratamentoResponse.setValorKilometragem(tratamentoResponse.getValorKilometragem());
        consultaTratamentoResponse.setPaciente(convertePaciente(tratamentoResponse.getPaciente()));
        consultaTratamentoResponse.setAcompanhante(converteAcompanhante(tratamentoResponse.getAcompanhante()));
        consultaTratamentoResponse.setProfissional(converteProfissional(tratamentoResponse.getProfissional()));
        consultaTratamentoResponse.setAtendimentos(converteAtendimentos(tratamentoResponse.getAtendimentos()));
        consultaTratamentoResponse.setSituacao(converteSituacaoTratamento(tratamentoResponse.getSituacoes()));

        return consultaTratamentoResponse;
    }

    private ConsultaTratamentoPacienteResponse convertePaciente(PacienteResponse paciente) {
        ConsultaTratamentoPacienteResponse consultaTratamentoPacienteResponse = new ConsultaTratamentoPacienteResponse();
        consultaTratamentoPacienteResponse.setId(paciente.getId());
        consultaTratamentoPacienteResponse.setNome(paciente.getNome());
        consultaTratamentoPacienteResponse.setSobrenome(paciente.getSobrenome());
        consultaTratamentoPacienteResponse.setCpf(paciente.getCpf());
        consultaTratamentoPacienteResponse.setDataNascimento(paciente.getDataNascimento());
        consultaTratamentoPacienteResponse.setGenero(!isNull(paciente.getGenero()) ? paciente.getGenero().getDescricao().name() : null);
        consultaTratamentoPacienteResponse.setContato(paciente.getContato());
        consultaTratamentoPacienteResponse.setEstadoCivil(!isNull(paciente.getEstadoCivil()) ? paciente.getEstadoCivil().getTipo().name() : null);
        consultaTratamentoPacienteResponse.setEndereco(paciente.getEndereco());
        return consultaTratamentoPacienteResponse;
    }

    private ConsultaTratamentoAcompanhanteResponse converteAcompanhante(AcompanhanteResponse acompanhante) {
        if (isNull(acompanhante)) return null;
        ConsultaTratamentoAcompanhanteResponse consultaTratamentoAcompanhanteResponse = new ConsultaTratamentoAcompanhanteResponse();
        consultaTratamentoAcompanhanteResponse.setId(acompanhante.getId());
        consultaTratamentoAcompanhanteResponse.setNomeCompleto(acompanhante.getNomeCompleto());
        consultaTratamentoAcompanhanteResponse.setCpf(acompanhante.getCpf());
        consultaTratamentoAcompanhanteResponse.setDataNascimento(acompanhante.getDataNascimento());
        consultaTratamentoAcompanhanteResponse.setGenero(acompanhante.getGenero().getDescricao().name());
        consultaTratamentoAcompanhanteResponse.setParentesco(acompanhante.getParentesco().getDescricao());
        consultaTratamentoAcompanhanteResponse.setContato(acompanhante.getContato());
        return consultaTratamentoAcompanhanteResponse;
    }

    private ConsultaTratamentoProfissionalResponse converteProfissional(AtendimentoProfissionalResponse profissional) {
        ConsultaTratamentoProfissionalResponse consultaTratamentoProfissionalResponse = new ConsultaTratamentoProfissionalResponse();
        consultaTratamentoProfissionalResponse.setId(profissional.getId());
        consultaTratamentoProfissionalResponse.setCpf(profissional.getCpf());
        consultaTratamentoProfissionalResponse.setNome(profissional.getNome());
        consultaTratamentoProfissionalResponse.setSobrenome(profissional.getSobrenome());
        consultaTratamentoProfissionalResponse.setConselho(profissional.getConselho());
        consultaTratamentoProfissionalResponse.setRegistro(profissional.getRegistro());
        consultaTratamentoProfissionalResponse.setCelular(profissional.getCelular());
        consultaTratamentoProfissionalResponse.setEspecialidades(profissional.getEspecialidades());
        return consultaTratamentoProfissionalResponse;
    }

    private List<ConsultaTratamentoAtendimentoResponse> converteAtendimentos(List<AtendimentoDetalheResponse> atendimentos) {
        return atendimentos.stream().map(atendimentoResponse -> {
            ConsultaTratamentoAtendimentoResponse consultaTratamentoAtendimentoResponse = new ConsultaTratamentoAtendimentoResponse();
            consultaTratamentoAtendimentoResponse.setId(atendimentoResponse.getId());
            consultaTratamentoAtendimentoResponse.setData(atendimentoResponse.getData());
            consultaTratamentoAtendimentoResponse.setHora(atendimentoResponse.getHora());
            consultaTratamentoAtendimentoResponse.setNomeProfissional(atendimentoResponse.getProfissional().getNome().concat(" ").concat(atendimentoResponse.getProfissional().getSobrenome()));
            consultaTratamentoAtendimentoResponse.setSituacao(converteSituacaoAtendimento(atendimentoResponse.getSituacoes()));
            consultaTratamentoAtendimentoResponse.setDescricaoProcedimento(null);
            consultaTratamentoAtendimentoResponse.setDescricaoMedicamento(null);
            consultaTratamentoAtendimentoResponse.setDescricaoEquipamento(null);
            return consultaTratamentoAtendimentoResponse;
        }).sorted(Comparator.comparing(ConsultaTratamentoAtendimentoResponse::getId).reversed()).collect(Collectors.toList());
    }

    private ConsultaTratamentoSituacaoResponse converteSituacaoTratamento(List<TratamentoSituacaoResponse> situacoes) {
        TratamentoSituacaoResponse tratamentoSituacaoResponse = situacoes.stream()
                .max(Comparator.comparing(TratamentoSituacaoResponse::getDataHora))
                .orElse(new TratamentoSituacaoResponse());

        ConsultaTratamentoSituacaoResponse consultaTratamentoSituacaoResponse = new ConsultaTratamentoSituacaoResponse();
        consultaTratamentoSituacaoResponse.setStatus(tratamentoSituacaoResponse.getStatus().getDescricao());
        consultaTratamentoSituacaoResponse.setDataHora(tratamentoSituacaoResponse.getDataHora());
        consultaTratamentoSituacaoResponse.setObservacao(null);

        return consultaTratamentoSituacaoResponse;
    }

    private ConsultaAtendimentoSituacaoResponse converteSituacaoAtendimento(List<AtendimentoSituacaoResponse> situacoes) {
        AtendimentoSituacaoResponse atendimentoSituacaoResponse = situacoes.stream()
                .max(Comparator.comparing(AtendimentoSituacaoResponse::getDataHora))
                .orElse(new AtendimentoSituacaoResponse());

        ConsultaAtendimentoSituacaoResponse consultaAtendimentoSituacaoResponse = new ConsultaAtendimentoSituacaoResponse();
        consultaAtendimentoSituacaoResponse.setStatus(atendimentoSituacaoResponse.getStatus().getDescricao());
        consultaAtendimentoSituacaoResponse.setDataHora(atendimentoSituacaoResponse.getDataHora());
        consultaAtendimentoSituacaoResponse.setObservacao(null);

        return consultaAtendimentoSituacaoResponse;
    }

}
