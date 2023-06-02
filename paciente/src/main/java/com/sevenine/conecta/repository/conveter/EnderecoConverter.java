package com.sevenine.conecta.repository.conveter;

import com.sevenine.conecta.adapter.controller.resource.EnderecoResource;
import com.sevenine.conecta.repository.entity.EnderecoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoConverter {

    private final ModelMapper mapper;

    public EnderecoResource toResource(EnderecoEntity entity) {
        EnderecoResource resource = new EnderecoResource();
        if (entity != null) {
            resource = mapper.map(entity, EnderecoResource.class);
        }
        return resource;
    }

    public EnderecoEntity toEntity(EnderecoResource resource) {
        EnderecoEntity entity = new EnderecoEntity();
        if (resource != null) {
            entity = mapper.map(resource, EnderecoEntity.class);
        }
        return entity;
    }

    public EnderecoEntity toEntity(EnderecoEntity entity, EnderecoResource resource) {
        entity.setLogradouro(resource.getLogradouro());
        entity.setNumero(resource.getNumero());
        entity.setComplemento(resource.getComplemento());
        entity.setFotoComprovante(resource.getFotoComprovante());
        entity.setCep(resource.getCep());
        entity.setBairro(resource.getBairro());
        entity.setCidade(resource.getCidade());
        entity.setEstado(resource.getEstado());

        return entity;
    }

}
