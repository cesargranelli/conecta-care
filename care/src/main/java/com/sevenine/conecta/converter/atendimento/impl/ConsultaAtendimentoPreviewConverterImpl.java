package com.sevenine.conecta.converter.atendimento.impl;

import com.sevenine.conecta.converter.atendimento.ConsultaAtendimentoPreviewConverter;
import com.sevenine.conecta.repository.data.Atendimento;
import com.sevenine.conecta.services.data.response.AtendimentoPreviewResponse;
import com.sevenine.conecta.services.data.response.AtendimentoProfissionalResponse;
import com.sevenine.conecta.services.data.response.PacienteResponse;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import static java.util.Objects.isNull;

@Component
public class ConsultaAtendimentoPreviewConverterImpl implements ConsultaAtendimentoPreviewConverter {

    @Override
    public List<AtendimentoPreviewResponse> fromListAtendimento(List<Atendimento> atendimentos, List<PacienteResponse> pacientes, List<AtendimentoProfissionalResponse> profissionais) {
        return atendimentos.stream()
                .map(atendimento -> {
                    AtendimentoPreviewResponse atendimentoPreviewResponse = new AtendimentoPreviewResponse();
                    atendimentoPreviewResponse.setId(atendimento.getId());
                    atendimentoPreviewResponse.setProtocolo(atendimento.getCodigoSeguranca());
                    //
                    atendimentoPreviewResponse.setProfissionalId(atendimento.getProfissionalId());
                    AtendimentoProfissionalResponse atendimentoProfissionalResponse = profissionais.stream()
                            .filter(profissionalResponse -> profissionalResponse.getId().equals(atendimento.getProfissionalId()))
                            .findAny()
                            .orElse(null);
                    if (!isNull(atendimentoProfissionalResponse)) {
                        atendimentoPreviewResponse.setProfissionalNome(atendimentoProfissionalResponse.getNome());
                        atendimentoPreviewResponse.setProfissionalCpf(atendimentoProfissionalResponse.getCpf());
                    }

                    //
                    atendimentoPreviewResponse.setTipoAtendimentoId(atendimento.getTipoAtendimento().getId().toString());
                    atendimentoPreviewResponse.setTipoAtendimentoNome(atendimento.getTipoAtendimento().getNome());

                    PacienteResponse pacienteResponse = pacientes.stream()
                            .filter(pacienteResponseFilter -> pacienteResponseFilter.getId().equals(atendimento.getPacienteId()))
                            .findAny()
                            .orElse(null); 
                    
                    atendimentoPreviewResponse.setPacienteId(atendimento.getId());
                    if (!isNull(pacienteResponse)) {
                        atendimentoPreviewResponse.setPacienteNome(pacienteResponse.getNome());
                        atendimentoPreviewResponse.setPacienteCpf(pacienteResponse.getCpf());
                    }
                    
                    atendimentoPreviewResponse.setData(atendimento.getData());
                    atendimentoPreviewResponse.setHora(atendimento.getHora());

                    atendimentoPreviewResponse.setStatusAtendimentoId(atendimento.statusRecente().getId().toString());
                    atendimentoPreviewResponse.setStatusAtendimentoDescricao(atendimento.statusRecente().getDescricao());
                    atendimentoPreviewResponse.setObservacao(atendimento.getObservacao());
                    
                    atendimentoPreviewResponse.setHomeCareId(atendimento.getHomeCareId());
                    atendimentoPreviewResponse.setHomeCareNome("Implementar");
                    
                    atendimentoPreviewResponse.setValorAjudaCusto(atendimento.getValorAjudaCusto());
                    atendimentoPreviewResponse.setValorHomeCare(atendimento.getValorHomeCare());
                    atendimentoPreviewResponse.setValorPaciente(atendimento.getValorPaciente());
                    atendimentoPreviewResponse.setValorProfissional(atendimento.getValorProfissional());
                    
                    return atendimentoPreviewResponse;
                }).collect(Collectors.toList());
    }

}
