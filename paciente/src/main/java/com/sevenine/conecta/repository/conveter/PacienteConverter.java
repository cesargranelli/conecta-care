package com.sevenine.conecta.repository.conveter;

import com.sevenine.conecta.adapter.controller.resource.PacienteNomeDocumentoResource;
import com.sevenine.conecta.adapter.controller.resource.PacienteResource;
import com.sevenine.conecta.repository.entity.PacienteEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class PacienteConverter {

    private final ModelMapper mapper;

    public PacienteEntity toEntity(PacienteResource resource) {
        PacienteEntity entity = new PacienteEntity();
        if (Objects.nonNull(resource)) {
            entity = mapper.map(resource, PacienteEntity.class);
        }
        return entity;
    }

    public PacienteResource toResource(PacienteEntity pacienteEntity) {
        return PacienteResource.builder()
                .id(pacienteEntity.getId())
                .nome(pacienteEntity.getNome())
                .sobrenome(pacienteEntity.getSobrenome())
                .cpf(pacienteEntity.getCpf())
                .dataNascimento(pacienteEntity.getDataNascimento())
                .rg(pacienteEntity.getRg())
                .rgEmissor(pacienteEntity.getRgEmissor())
                .rgDataEmissao(pacienteEntity.getRgDataEmissao())
                .foto(pacienteEntity.getFoto())
                .fotoRg(pacienteEntity.getFotoRg())
                .fotoCpf(pacienteEntity.getFotoCpf())
                .genero(pacienteEntity.getGenero())
                .estadoCivil(pacienteEntity.getEstadoCivil())
                .endereco(pacienteEntity.getEndereco())
                .contato(pacienteEntity.getContato())
                .historicoMedico(pacienteEntity.getHistoricoMedico())
                .build();
    }

    public List<PacienteNomeDocumentoResource> toResource(List<PacienteEntity> pacientes) {
        if (isNull(pacientes)) return null;
        return pacientes.stream().map(paciente -> PacienteNomeDocumentoResource.builder()
                .id(paciente.getId())
                .nomeCompleto(paciente.getNome().concat(paciente.getSobrenome()))
                .cpf(paciente.getCpf())
                .build()).collect(Collectors.toList());
    }

    public List<PacienteResource> toListResource(List<PacienteEntity> pacientes) {
        return pacientes.stream().map(paciente -> PacienteResource.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .sobrenome(paciente.getSobrenome())
                .cpf(paciente.getCpf())
                .dataNascimento(paciente.getDataNascimento())
                .genero(paciente.getGenero())
                .estadoCivil(paciente.getEstadoCivil())
                .contato(paciente.getContato())
                .endereco(paciente.getEndereco())
                .build()).collect(Collectors.toList());
    }

}
