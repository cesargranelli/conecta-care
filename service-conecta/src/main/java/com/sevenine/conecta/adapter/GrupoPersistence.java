package com.sevenine.conecta.adapter;

import com.sevenine.conecta.domain.model.Grupo;
import com.sevenine.conecta.domain.port.persistence.DominioPersistence;
import com.sevenine.conecta.mapper.DominioMapper;
import com.sevenine.conecta.repository.GrupoRepository;
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
