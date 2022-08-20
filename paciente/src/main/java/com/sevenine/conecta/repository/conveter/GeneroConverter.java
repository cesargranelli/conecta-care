package com.sevenine.conecta.repository.conveter;

import com.sevenine.conecta.http.resource.GeneroResource;
import com.sevenine.conecta.repository.entity.GeneroEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GeneroConverter {

    private final ModelMapper mapper;

    public GeneroResource toResource(GeneroEntity entity) {
        GeneroResource resource = new GeneroResource();
        if(entity != null) {
            resource = mapper.map(entity, GeneroResource.class);
        }
        return resource;
    }

}
