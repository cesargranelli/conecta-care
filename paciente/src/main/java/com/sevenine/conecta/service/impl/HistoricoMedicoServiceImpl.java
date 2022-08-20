package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.http.resource.HistoricoMedicoResource;
import com.sevenine.conecta.infra.enumerator.ErrorMappingEnum;
import com.sevenine.conecta.infra.exception.PacienteException;
import com.sevenine.conecta.repository.HistoricoMedicoRepository;
import com.sevenine.conecta.repository.conveter.HistoricoMedicoConverter;
import com.sevenine.conecta.repository.entity.HistoricoMedicoEntity;
import com.sevenine.conecta.service.HistoricoMedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistoricoMedicoServiceImpl implements HistoricoMedicoService {

    private final HistoricoMedicoRepository historicoMedicoRepository;

    private final HistoricoMedicoConverter historicoMedicoConverter;

    @Override
    public HistoricoMedicoResource create(HistoricoMedicoResource resource) {
        resource.setId(null);
        HistoricoMedicoEntity entity = historicoMedicoConverter.toEntity(resource);
        return historicoMedicoConverter.toResource(historicoMedicoRepository.save(entity));
    }

    @Override
    public HistoricoMedicoResource find(Long id) {
        Optional<HistoricoMedicoEntity> entity = historicoMedicoRepository.findById(id);
        if(!entity.isPresent())
            return null;
        return historicoMedicoConverter.toResource(entity.get());
    }

    @Override
    public HistoricoMedicoResource edit(HistoricoMedicoResource resource) {
        if(resource == null || resource.getId() == null)
            throw new PacienteException(ErrorMappingEnum.ID_HISTORICO_MEDICO_PACIENTE_OBRIGATORIO, HttpStatus.BAD_REQUEST);

        Optional<HistoricoMedicoEntity> entity = historicoMedicoRepository.findById(resource.getId());
        if(!entity.isPresent())
            throw new PacienteException(ErrorMappingEnum.ID_HISTORICO_MEDICO_PACIENTE_NAO_ENCONTRADO, HttpStatus.BAD_REQUEST);

        return historicoMedicoConverter.toResource(historicoMedicoRepository.save(historicoMedicoConverter.toEntity(resource)));
    }

}
