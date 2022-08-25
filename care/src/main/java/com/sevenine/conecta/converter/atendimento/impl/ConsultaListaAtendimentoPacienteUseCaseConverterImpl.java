package com.sevenine.conecta.converter.atendimento.impl;

import com.sevenine.conecta.controllers.data.response.atendimento.AtendimentoPacienteProtocoloResponse;
import com.sevenine.conecta.controllers.data.response.atendimento.AtendimentoPacienteResponse;
import com.sevenine.conecta.converter.atendimento.ConsultaListaAtendimentoPacienteUseCaseConverter;
import com.sevenine.conecta.services.data.response.AtendimentoResponse;
import com.sevenine.conecta.services.data.response.AtendimentoSituacaoResponse;
import com.sevenine.conecta.services.data.response.AtendimentoProfissionalResponse;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ConsultaListaAtendimentoPacienteUseCaseConverterImpl implements ConsultaListaAtendimentoPacienteUseCaseConverter {

    @Override
    public List<AtendimentoPacienteResponse> fromResponseService(List<AtendimentoResponse> atendimentos,
                                                                 List<AtendimentoProfissionalResponse> profissionais) {
        return atendimentos.stream()
                .map(atendimento -> {
                    AtendimentoPacienteResponse atendimentoPacienteResponse = new AtendimentoPacienteResponse();
                    atendimentoPacienteResponse.setId(atendimento.getId());
                    atendimentoPacienteResponse.setData(atendimento.getData());
                    atendimentoPacienteResponse.setHora(atendimento.getHora());
                    atendimentoPacienteResponse.setStatus(statusRecente(atendimento.getSituacoes()));
                    atendimentoPacienteResponse.setProtocolo(atendimentoPacienteProtocolo(atendimento));
                    atendimentoPacienteResponse.setNomeProfissional(
                            nomeProfissional(atendimento.getProfissionalId(), profissionais));
                    atendimentoPacienteResponse.setRegistroProfissional(
                            registroProfissional(atendimento.getProfissionalId(), profissionais));
                    return atendimentoPacienteResponse;
                })
                .collect(Collectors.toList());
    }

    private String statusRecente(List<AtendimentoSituacaoResponse> situacoes) {
        if (isNull(situacoes) || situacoes.isEmpty()) return null;
        return situacoes.stream().max(Comparator.comparing(AtendimentoSituacaoResponse::getDataHora))
                .orElse(new AtendimentoSituacaoResponse()).getStatus().getDescricao();
    }

    private AtendimentoPacienteProtocoloResponse atendimentoPacienteProtocolo(AtendimentoResponse atendimento) {
        AtendimentoPacienteProtocoloResponse atendimentoPacienteProtocolo = new AtendimentoPacienteProtocoloResponse();
        atendimentoPacienteProtocolo.setTratamentoId(atendimento.getTratamentoId());
        atendimentoPacienteProtocolo.setAtendimentoId(atendimento.getId());
        atendimentoPacienteProtocolo.setHomeCareId(atendimento.getHomeCareId());
        atendimentoPacienteProtocolo.setProfissionalId(atendimento.getProfissionalId());
        atendimentoPacienteProtocolo.setPacienteId(atendimento.getPacienteId());
        atendimentoPacienteProtocolo.setCodigoSeguranca(atendimento.getCodigoSeguranca());
        return atendimentoPacienteProtocolo;
    }

    private String nomeProfissional(Long profissionalId, List<AtendimentoProfissionalResponse> profissionais) {
        return profissionais.stream().filter(profissional -> profissional.getId().equals(profissionalId))
                .map(profissional -> profissional.getNome().concat(" ").concat(profissional.getSobrenome()))
                .findAny().orElse("");
    }

    private String registroProfissional(Long profissionalId, List<AtendimentoProfissionalResponse> profissionais) {
        return profissionais.stream().filter(profissional -> profissional.getId().equals(profissionalId))
                .map(profissional -> profissional.getConselho().concat(" ").concat(profissional.getRegistro())
                        .concat(" - ").concat(profissional.getConselhoUf())).findAny().orElse("");
    }

}
