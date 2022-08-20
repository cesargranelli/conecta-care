package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.http.resource.ContatoResource;
import com.sevenine.conecta.infra.enumerator.ErrorMappingEnum;
import com.sevenine.conecta.infra.exception.PacienteException;
import com.sevenine.conecta.repository.ContatoRepository;
import com.sevenine.conecta.repository.PacienteRepository;
import com.sevenine.conecta.repository.conveter.ContatoConverter;
import com.sevenine.conecta.repository.entity.ContatoEntity;
import com.sevenine.conecta.repository.entity.EnderecoEntity;
import com.sevenine.conecta.repository.entity.PacienteEntity;
import com.sevenine.conecta.service.AtivaUsuarioService;
import com.sevenine.conecta.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;
    private final PacienteRepository pacienteRepository;

    private final ContatoConverter contatoConverter;

    private final AtivaUsuarioService ativaUsuarioService;

    @Override
    public ContatoResource create(ContatoResource resource) {
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(resource.getIdPaciente());

        if (!pacienteEntity.isPresent()) {
            throw new PacienteException(ErrorMappingEnum.ID_CONTATO_PACIENTE_OBRIGATORIO, HttpStatus.BAD_REQUEST);
        } else if (Objects.nonNull(pacienteEntity.get().getContato())) {
            throw new PacienteException(ErrorMappingEnum.PACIENTE_JA_POSSUI_CONTATO, HttpStatus.BAD_REQUEST);
        }

        ContatoEntity contatoEntity = contatoConverter.toEntity(resource);
        this.contatoRepository.save(contatoEntity);

        pacienteEntity.get().setContato(contatoEntity);
        this.pacienteRepository.save(pacienteEntity.get());

        ativaUsuarioService.ativar(resource.getIdPaciente());

        return contatoConverter.toResource(contatoEntity);
    }

    @Override
    public ContatoResource find(Long id) {
        Optional<ContatoEntity> entity = contatoRepository.findById(id);
        if(!entity.isPresent())
            return null;
        return contatoConverter.toResource(entity.get());
    }

    @Override
    public ContatoResource edit(ContatoResource resource) {
        Optional<PacienteEntity> optionalPaciente = pacienteRepository.findById(resource.getIdPaciente());

        PacienteEntity pacienteEntity =
                optionalPaciente.orElseThrow(() ->
                        new PacienteException(ErrorMappingEnum.ID_CONTATO_PACIENTE_NAO_ENCONTRADO, HttpStatus.BAD_REQUEST));

        if (isNull(pacienteEntity.getContato())) {
            return this.create(resource);
        }

        Optional<ContatoEntity> optionalContato = contatoRepository.findById(pacienteEntity.getContato().getId());

        ContatoEntity contatoEntity =
                optionalContato.orElseThrow(() ->
                        new PacienteException(ErrorMappingEnum.ID_CONTATO_PACIENTE_NAO_ENCONTRADO, HttpStatus.BAD_REQUEST));

        ContatoEntity contato = contatoConverter.toEntity(contatoEntity, resource);
        contatoRepository.flush();

        return contatoConverter.toResource(contato);
    }

}
