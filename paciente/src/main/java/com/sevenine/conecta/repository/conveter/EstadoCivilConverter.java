package com.sevenine.conecta.repository.conveter;

import com.sevenine.conecta.controllers.resource.EstadoCivilResource;
import com.sevenine.conecta.repository.entity.EstadoCivilEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstadoCivilConverter {

    private final ModelMapper mapper;

    public EstadoCivilResource toResource(EstadoCivilEntity entity) {
        EstadoCivilResource resource = new EstadoCivilResource();
        if(entity != null) {
            resource = mapper.map(entity, EstadoCivilResource.class);
        }
        return resource;
    }

}
