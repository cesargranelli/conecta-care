package com.sevenine.conecta.repository.conveter;

import com.sevenine.conecta.http.resource.HistoricoMedicoResource;
import com.sevenine.conecta.repository.entity.HistoricoMedicoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistoricoMedicoConverter {

    private final ModelMapper mapper;

    public HistoricoMedicoResource toResource(HistoricoMedicoEntity entity) {
        HistoricoMedicoResource resource = new HistoricoMedicoResource();
        if (entity != null) {
            resource = mapper.map(entity, HistoricoMedicoResource.class);
        }
        return resource;
    }

    public HistoricoMedicoEntity toEntity(HistoricoMedicoResource resource) {
        HistoricoMedicoEntity entity = new HistoricoMedicoEntity();
        if (resource != null) {
            entity = mapper.map(resource, HistoricoMedicoEntity.class);
        }
        return entity;
    }

}
