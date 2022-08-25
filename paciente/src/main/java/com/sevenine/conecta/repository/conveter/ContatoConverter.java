package com.sevenine.conecta.repository.conveter;

import com.sevenine.conecta.controllers.resource.ContatoResource;
import com.sevenine.conecta.repository.entity.ContatoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContatoConverter {

    private final ModelMapper mapper;

    public ContatoResource toResource(ContatoEntity entity) {
        ContatoResource resource = new ContatoResource();
        if (entity != null) {
            resource = mapper.map(entity, ContatoResource.class);
        }
        return resource;
    }

    public ContatoEntity toEntity(ContatoResource resource) {
        ContatoEntity entity = new ContatoEntity();
        if (resource != null) {
            entity = mapper.map(resource, ContatoEntity.class);
        }
        return entity;
    }

    public ContatoEntity toEntity(ContatoEntity entity, ContatoResource resource) {
        entity.setTelefoneFixo(resource.getTelefoneFixo());
        entity.setTelefoneCelular(resource.getTelefoneCelular());
        entity.setTelefoneRecado(resource.getTelefoneRecado());
        entity.setTelefoneResponsavel(resource.getTelefoneResponsavel());
        entity.setEmailResponsavel(resource.getEmailResponsavel());

        return entity;
    }
}
