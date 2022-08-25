package com.sevenine.conecta.services.impl;

import com.sevenine.conecta.controllers.resource.PacienteNomeDocumentoResource;
import com.sevenine.conecta.controllers.resource.PacientePesquisaResource;
import com.sevenine.conecta.controllers.resource.PacienteResource;
import com.sevenine.conecta.infra.enumerator.ErrorMappingEnum;
import com.sevenine.conecta.infra.exception.PacienteException;
import com.sevenine.conecta.repository.PacientePesquisaRepository;
import com.sevenine.conecta.repository.PacienteRepository;
import com.sevenine.conecta.repository.conveter.PacienteConverter;
import com.sevenine.conecta.repository.entity.PacienteEntity;
import com.sevenine.conecta.repository.entity.PacientePesquisaEntity;
import com.sevenine.conecta.services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    private final PacienteConverter pacienteConverter;

    private final PacientePesquisaRepository pacientePesquisaRepository;

    @Override
    public PacienteResource create(PacienteResource resource) {
        PacienteEntity entity = pacienteConverter.toEntity(resource);
        return pacienteConverter.toResource(pacienteRepository.save(entity));
    }

    @Override
    public PacienteResource find(Long id) {
        Optional<PacienteEntity> entity = pacienteRepository.findById(id);
        return entity.map(pacienteConverter::toResource).orElse(null);
    }

    @Override
    public PacienteResource findByCpf(String cpf) {
        Optional<PacienteEntity> entity = pacienteRepository.findByCpf(cpf);
        return entity.map(pacienteConverter::toResource).orElse(null);
    }

    @Override
    public PacienteResource edit(PacienteResource resource) {
        if (resource == null || resource.getId() == null)
            throw new PacienteException(ErrorMappingEnum.ID_PACIENTE_OBRIGATORIO, HttpStatus.BAD_REQUEST);

        Optional<PacienteEntity> entity = pacienteRepository.findById(resource.getId());
        if (!entity.isPresent())
            throw new PacienteException(ErrorMappingEnum.ID_PACIENTE_NAO_ENCONTRADO, HttpStatus.BAD_REQUEST);

        return pacienteConverter.toResource(pacienteRepository.save(pacienteConverter.toEntity(resource)));
    }

    @Override
    public List<PacienteNomeDocumentoResource> findByNome(String nome) {
        Optional<List<PacienteEntity>> optionalList = pacienteRepository.findByNomeCompletoLike(nome);
        return pacienteConverter.toResource(optionalList.orElse(null));
    }

    @Override
    public List<PacienteResource> findByListId(List<Long> idsPacientes) {
        Optional<List<PacienteEntity>> optionalList = pacienteRepository.findByIdIn(idsPacientes);
        return pacienteConverter.toListResource(optionalList.orElse(new ArrayList<>()));
    }

    @Override
    public List<PacientePesquisaResource> getCpfListByName(String nome) {
        List<PacientePesquisaEntity> listaCpf = pacientePesquisaRepository.findByNomeCompletoLike(nome).orElseThrow(() -> new PacienteException("Não há nenhum paciente com esse nome.", HttpStatus.NO_CONTENT));
        List<PacientePesquisaResource> lista = new ArrayList<>();
        for (int i = 0; i < listaCpf.size(); i++) {
            PacientePesquisaResource pacientePesquisaResource = new PacientePesquisaResource();
            pacientePesquisaResource.setCpf(listaCpf.get(i).getCpf());
            pacientePesquisaResource.setNomeCompleto(listaCpf.get(i).getNome() + " " + listaCpf.get(i).getSobrenome());
            lista.add(pacientePesquisaResource);
        }
        return lista;
    }

}
