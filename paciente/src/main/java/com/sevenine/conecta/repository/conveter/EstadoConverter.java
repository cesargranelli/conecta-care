package com.sevenine.conecta.repository.conveter;

import com.sevenine.conecta.controllers.resource.EstadoResource;
import com.sevenine.conecta.repository.entity.EstadoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstadoConverter {

    private final ModelMapper mapper;

    public EstadoResource toResource(EstadoEntity entity) {
        EstadoResource resource = new EstadoResource();
        if(entity != null){
            resource = mapper.map(entity, EstadoResource.class);
        }
        return resource;
    }

}
