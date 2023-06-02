package com.sevenine.conecta.repository.conveter;

import com.sevenine.conecta.adapter.controller.resource.TipoSanguineoResource;
import com.sevenine.conecta.repository.entity.TipoSanguineoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipoSanguineoConverter {

    private final ModelMapper mapper;

    public TipoSanguineoResource toResource(TipoSanguineoEntity entity) {
        TipoSanguineoResource resource = new TipoSanguineoResource();
        if(entity != null) {
            resource = mapper.map(entity, TipoSanguineoResource.class);
        }
        return resource;
    }

}
