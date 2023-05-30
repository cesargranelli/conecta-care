package com.sevenine.conecta.adapters;

import com.sevenine.conecta.domain.entities.Grupo;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import com.sevenine.conecta.mappers.DominioMapper;
import com.sevenine.conecta.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoPersistence implements DominioPersistence<Object, List<Grupo>> {

    @Autowired
    private final GrupoRepository repository;

    public GrupoPersistence(GrupoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Grupo> execute(Object[] objects) {
        return DominioMapper.INSTANCE.toGrupo(repository.findAll());
    }

}
