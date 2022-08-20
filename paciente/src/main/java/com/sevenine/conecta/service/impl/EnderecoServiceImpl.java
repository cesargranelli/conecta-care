package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.http.resource.EnderecoResource;
import com.sevenine.conecta.infra.enumerator.ErrorMappingEnum;
import com.sevenine.conecta.infra.exception.PacienteException;
import com.sevenine.conecta.repository.EnderecoRepository;
import com.sevenine.conecta.repository.PacienteRepository;
import com.sevenine.conecta.repository.conveter.EnderecoConverter;
import com.sevenine.conecta.repository.entity.EnderecoEntity;
import com.sevenine.conecta.repository.entity.PacienteEntity;
import com.sevenine.conecta.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final EnderecoConverter enderecoConverter;

    private final PacienteRepository pacienteRepository;

    @Override
    public EnderecoResource create(EnderecoResource resource) {
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(resource.getIdPaciente());

        if (!pacienteEntity.isPresent()) {
            throw new PacienteException(ErrorMappingEnum.ID_PACIENTE_NAO_ENCONTRADO, HttpStatus.BAD_REQUEST);
        } else if (Objects.nonNull(pacienteEntity.get().getEndereco())) {
            throw new PacienteException(ErrorMappingEnum.PACIENTE_JA_POSSUI_ENDERECO, HttpStatus.BAD_REQUEST);
        }

        EnderecoEntity enderecoEntity = enderecoConverter.toEntity(resource);
        this.enderecoRepository.save(enderecoEntity);

        pacienteEntity.get().setEndereco(enderecoEntity);
        this.pacienteRepository.save(pacienteEntity.get());

        return enderecoConverter.toResource(enderecoEntity);
    }

    @Override
    public EnderecoResource findById(Long id) {
        Optional<EnderecoEntity> entity = this.enderecoRepository.findById(id);
        return entity.map(enderecoConverter::toResource).orElse(null);
    }

    @Override
    public EnderecoResource findByIdPaciente(Long id) {
        Optional<EnderecoEntity> entity = this.enderecoRepository.findByIdPaciente(id);
        return entity.map(enderecoConverter::toResource).orElse(null);
    }

    @Override
    public EnderecoResource edit(EnderecoResource resource) {
        Optional<PacienteEntity> optionalPaciente = pacienteRepository.findById(resource.getIdPaciente());

        PacienteEntity pacienteEntity =
                optionalPaciente.orElseThrow(() ->
                        new PacienteException(ErrorMappingEnum.ID_ENDERECO_PACIENTE_NAO_ENCONTRADO, HttpStatus.BAD_REQUEST));

        if (isNull(pacienteEntity.getEndereco())) {
            return this.create(resource);
        }

        Optional<EnderecoEntity> optionalEndereco = enderecoRepository.findById(pacienteEntity.getEndereco().getId());

        EnderecoEntity enderecoEntity =
                optionalEndereco.orElseThrow(() ->
                        new PacienteException(ErrorMappingEnum.ID_ENDERECO_PACIENTE_NAO_ENCONTRADO, HttpStatus.BAD_REQUEST));

        EnderecoEntity endereco = enderecoConverter.toEntity(enderecoEntity, resource);
        enderecoRepository.flush();

        return enderecoConverter.toResource(endereco);
    }
}
